import java.util.Collection;

public class Box2<T extends Number> {
    private T content;

    // Метод для помещения объекта в коробку
    public void put(T item) {
        if (content != null) {
            throw new IllegalStateException("The box already contains an item. Cannot place another.");
        }
        content = item;
    }

    // Метод для извлечения объекта из коробки
    public T get() {
        if (content == null) {
            return null;
        }
        T item = content;
        content = null;
        return item;
    }

    // Метод для проверки, заполнена ли коробка
    public boolean isFilled() {
        return content != null;
    }

    public T getBox() {
        return content;
    }

    // Статический метод для получения максимального значения из двух коробок
    public static <T extends Number> double max(Box2<T> box1, Box2<T> box2) {
        if (!box1.isFilled() || !box2.isFilled()) {
            throw new IllegalStateException("Both boxes must be filled to compare values.");
        }

        double value1 = box1.content.doubleValue();
        double value2 = box2.content.doubleValue();

        return Math.max(value1, value2);
    }
}
