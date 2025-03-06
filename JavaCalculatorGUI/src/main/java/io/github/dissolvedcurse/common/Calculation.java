package io.github.dissolvedcurse.common;

/**
 * Класс Calculation выполняет базовые арифметические операции.
 */
public class Calculation {
    /**
     * Метод для выполнения вычисления на основе переданных операндов и операции.
     * @param a Первый операнд
     * @param operation Строка, представляющая операцию (+, -, *, /)
     * @param b Второй операнд
     * @return Результат вычисления
     * @throws ArithmeticException если происходит деление на ноль
     * @throws IllegalArgumentException если передана недопустимая операция
     */
    public double calculate(double a, String operation ,double b) {
        switch (operation) {
            case "+": // Сложение
                return a + b;
            case "-": // Вычитание
                return a - b;
            case "*": // Умножение
                return a * b;
            case "/": // Деление с проверкой деления на ноль
                if (b == 0) {
                    throw new ArithmeticException("Error: Cannot divide by zero");
                }
                return a / b;
            default: // Обработка некорректной операции
                throw new IllegalArgumentException("Error: invalid operation -> " + operation);
        }
    }
}