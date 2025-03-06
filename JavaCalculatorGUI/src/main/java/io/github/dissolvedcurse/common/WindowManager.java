package io.github.dissolvedcurse.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Класс WindowManager отвечает за создание графического интерфейса калькулятора.
 */
public class WindowManager {
    /**
     * Метод создает основное окно GUI калькулятора.
     */
    public void createWindow() {
        String[] operations = {"+", "-", "*", "/"}; // Доступные операции

        // Создание окна калькулятора
        JFrame frame = new JFrame("Calculator GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);

        Font numbersFont = new Font("Arial", Font.PLAIN, 20); // Шрифт для полей ввода

        // Поле ввода первого числа
        JTextField firstNumber = new JTextField("Enter First Number");
        firstNumber.setBounds(150, 50, 300, 50);
        firstNumber.setFont(numbersFont);

        // Поле ввода второго числа
        JTextField secondNumber = new JTextField("Enter Second Number");
        secondNumber.setBounds(150, 120, 300, 50);
        secondNumber.setFont(numbersFont);

        // Выпадающий список выбора операции
        JComboBox<String> operationComboBox = new JComboBox<>(operations);
        operationComboBox.setBounds(150, 200, 300, 50);
        operationComboBox.setFont(numbersFont);

        // Кнопка вычисления
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(150, 250, 300, 50);
        calculateButton.setFont(numbersFont);

        // Метка для вывода результата
        JLabel resultLabel = new JLabel("Result");
        resultLabel.setBounds(270, 350, 300, 50);
        resultLabel.setFont(numbersFont);

        // Обработчик нажатия кнопки вычисления
        calculateButton.addActionListener(_ -> {
            try {
                // Получение введенных данных
                String firstText = firstNumber.getText();
                String secondText = secondNumber.getText();

                // Проверка на пустые поля
                if (firstText.isEmpty() || secondText.isEmpty()) {
                    resultLabel.setText("Error: fields can't be empty");
                    return;
                }

                // Преобразование строк в числа
                double a = Double.parseDouble(firstText);
                double b = Double.parseDouble(secondText);

                // Получение выбранной операции
                String operation = (String) operationComboBox.getSelectedItem();

                // Выполнение вычисления и вывод результата
                Calculation calculation = new Calculation();
                assert operation != null;
                resultLabel.setText("Result: " + calculation.calculate(a, operation, b));
            } catch (NumberFormatException ex) {
                resultLabel.setText("Error: please input number!"); // Ошибка, если ввод не является числом
            } catch (ArithmeticException | IllegalArgumentException ex) {
                resultLabel.setText("Error: " + ex.getMessage()); // Ошибка при вычислении
            } catch (Exception ex) {
                resultLabel.setText("Unknown Error: " + ex.getMessage()); // Непредвиденная ошибка
            }
        });

        // Очистка текста при фокусе на поле ввода
        firstNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (firstNumber.getText().equals("Enter First Number")) {
                    firstNumber.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (firstNumber.getText().isEmpty()) {
                    firstNumber.setText("Enter First Number");
                }
            }
        });

        secondNumber.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (secondNumber.getText().equals("Enter First Number")) {
                    secondNumber.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (secondNumber.getText().isEmpty()) {
                    secondNumber.setText("Enter First Number");
                }
            }
        });

        // Добавление компонентов на окно
        frame.add(firstNumber);
        frame.add(secondNumber);
        frame.add(operationComboBox);
        frame.add(calculateButton);
        frame.add(resultLabel);

        frame.setVisible(true); // Отображение окна
    }
}