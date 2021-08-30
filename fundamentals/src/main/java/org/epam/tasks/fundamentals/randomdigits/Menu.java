package org.epam.tasks.fundamentals.randomdigits;

import java.util.Scanner;

/**
 * Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
 * run StartMainUnit to start the program
 */
public class Menu {
    private int digitQuantity = setQuantity();
    private int caretType = setCaret();

    private int setQuantity() {
        Scanner scanner = new Scanner(System.in);
        String invitationQuantity = "type quantity of digits(integer) in range 2-200 >>";
        System.out.print(invitationQuantity);
        while (!scanner.hasNextInt()) {
            System.out.print(invitationQuantity);
            scanner.next();
        }
        int digitIn = scanner.nextInt();
        if (digitIn >= 2 && digitIn <= 200) {
            digitQuantity = digitIn;
        } else {
            setQuantity();
        }
        return digitQuantity;
    }

    private int setCaret() {
        caretType = -1;
        Scanner scanner = new Scanner(System.in);
        String invitation = "choose view variant: return caret view - type \"0\", line view - type \"1\" >>";
        System.out.print(invitation);
        while (!scanner.hasNextInt()) {
            System.out.print(invitation);
            scanner.next();
        }
        int digitIn = scanner.nextInt();
        if (digitIn == 0 || digitIn == 1) {
            caretType = digitIn;
        } else {
            setCaret();
        }
        return caretType;

    }

    public void startMainUnit() {
        System.out.println("Quantity of digits: " + digitQuantity);
        if (caretType == 0) {
            System.out.println(" return caret view is selected");
        } else {
            System.out.println(" line view is selected");
        }

    }

    public int getDigitQuantity() {
        return digitQuantity;
    }

    public int getCaretType() {
        return caretType;
    }
}
