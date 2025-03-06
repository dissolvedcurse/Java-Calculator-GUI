package io.github.dissolvedcurse;

import io.github.dissolvedcurse.common.WindowManager;

/**
 * Главный класс, запускающий калькулятор.
 */
public class Main {
    public static void main(String[] args) {
        WindowManager windowManager = new WindowManager();

        windowManager.createWindow(); // Вызов метода для создания окна
    }
}