package org.epam.tasks.fundamentals.randomdigits;

/**
 * Initialization module. Start it here
 */

public class StartMainUnit {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.startMainUnit();
        DigitGenerator digitGenerator = new DigitGenerator(menu.getDigitQuantity(), menu.getCaretType());
        digitGenerator.startSolution();
    }
}
