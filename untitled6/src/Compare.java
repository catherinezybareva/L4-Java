// Определение интерфейса Сравнимое
public interface Compare<T> {
    // Метод "сравнить", принимающий объект типа T и возвращающий целое число
    int compare(T object);
}