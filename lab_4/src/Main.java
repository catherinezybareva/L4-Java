import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // ЗАДАЧА 1-1

        System.out.println("Задача 1.1 Обобщённая коробка \n ");
        // Создаем коробку, которая может хранить только целые числа
        Box<Integer> intBox = new Box<>();

        // Размещаем в коробке число 3
        intBox.put(3);

        // Проверяем заполненность коробки и извлекаем содержимое
        if (intBox.isFilled()) {
            Integer value = intBox.get();
            System.out.println("Значение из коробки: " + value);
        }

        // Передача коробки в метод и вывод результата
        processBox(intBox);

        //ЗАДАЧА 1-3

        System.out.println("\nЗадача 1.3 Сравнимое \n ");

        Count count1 = new Count(5);
        Count count2 = new Count(10);

        System.out.println("Сравниваемые значения: " + count1.getValue() + " и " + count2.getValue());

        // Вызов метода "сравнить" и вывод результата
        System.out.println("\nВарианты результатов: ");
        System.out.println("-1, когда первое число больше второго ");
        System.out.println("1, когда второе число больше первого ");
        System.out.println("0, когда оба числа равны ");
        System.out.println("Результат сравнения: " + count1.compare(count2));
        // Ожидаемый вывод: "Результат сравнения: -1", так как 5 < 10

        //ЗАДАЧА 2-2

        System.out.println("\nЗадача 2.2 Поиск максимума \n ");

        Box2<Integer> intBox1 = new Box2<>();
        Box2<Integer> intBox2 = new Box2<>();

        intBox1.put(10);
        intBox2.put(20);

        System.out.println("Ищем максимум из значений: " + intBox1.getBox() + " и " + intBox2.getBox());

        System.out.println("Максимальное значение: " + Box2.max(intBox1, intBox2)); // Output: Max value: 20.0

        Box2<Double> doubleBox1 = new Box2<>();
        Box2<Double> doubleBox2 = new Box2<>();

        doubleBox1.put(15.5);
        doubleBox2.put(12.3);

        System.out.println("Ищем максимум из значений: " + doubleBox1.getBox() + " и " + doubleBox2.getBox());

        System.out.println("Максимальное значение: " + Box2.max(doubleBox1, doubleBox2)); // Output: Max value: 15.5

        //ЗАДАЧА 3-1

        System.out.println("\nЗадача 3.1 Функция \n ");

        GenericTransformer transformer = new GenericTransformer();

        // Пример 1: Длина строки
        List<String> strings = Arrays.asList("qwerty", "asdfg", "zx");
        List<Integer> lengths = transformer.transform(strings, String::length);
        System.out.println("Длины строк: " + lengths);

        // Пример 2: Абсолютное значение
        List<Integer> numbers = Arrays.asList(1, -3, 7);
        List<Integer> absolutes = transformer.transform(numbers, Math::abs);
        System.out.println("Абсолютные значения: " + absolutes);

        // Пример 3: Максимум в массиве
        List<int[]> arrays = Arrays.asList(
                new int[]{1, 2, 3},
                new int[]{7, 0, -1},
                new int[]{5, 10, 15}
        );
        List<Integer> maxValues = transformer.transform(arrays, array -> Arrays.stream(array).max().orElseThrow());
        System.out.println("Максимальные значения: " + maxValues); // [3, 7, 15]

        //ЗАДАЧА 3-2

        System.out.println("\nЗадача 3.2 Фильтр \n ");

        FilterUtils filter = new FilterUtils();
        List<String> strings2 = List.of("qwerty", "asdfg", "zx");
        List<String> filteredStrings = filter.filter(strings2, s -> s.length() >= 3);
        System.out.println("Отфильтрованные строки: " + filteredStrings);

        // 2. Фильтрация положительных чисел
        List<Integer> numbers2 = List.of(1, -3, 7);
        List<Integer> filteredNumbers = filter.filter(numbers2, n -> n <= 0);
        System.out.println("Отфильтрованные числа: " + filteredNumbers);

        // 3. Фильтрация массивов целых чисел, где нет положительных элементов
        List<int[]> arrays2 = List.of(
                new int[]{1, -2, 3},
                new int[]{-4, -5, -6},
                new int[]{0, -1, -3}
        );
        List<int[]> filteredArrays = filter.filter(arrays2, array -> {
            for (int num : array) {
                if (num > 0) {
                    return false;
                }
            }
            return true;
        });
        // Вывод отфильтрованных массивов
        System.out.println("Отфильтрованные массивы:");
        for (int[] array : filteredArrays) {
            System.out.print("[");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println("]");
        }
    }

        // Метод, который принимает коробку и извлекает её содержимое
        public static void processBox (Box < Integer > box) {
            if (box.isFilled()) {
                Integer value = box.get();
                System.out.println("Результат метода: " + value);
            } else {
                System.out.println("Коробка пуста");
            }
        }
    }