class Numbers implements Compare<Numbers> {
    private int value;

    // Конструктор
    public Numbers(int value) {
        this.value = value;
    }

    // Реализация метода "сравнить"
    public int compare(Numbers anotherObject) {
        return Integer.compare(this.value, anotherObject.value);
    }

    // Геттер для значения (необязательно, для удобства)
    public int getValue() {
        return value;
    }
}