package org.epam.tasks.fundamentals.dayofyear;

import java.util.Scanner;

public class StartUnit {

    public static void main(String[] args) {
        startProgram();
    }

    private static void startProgram() {
        MainUnit mainUnit = new MainUnit();
        int x = enterDigit();
        if (x > 0 && x < 13) {
            mainUnit.monthName(x);
        } else {
          startProgram();
        }
    }

    private static int enterDigit() {
        String invitation = "type number of month (in range 1 - 12) >> ";
        System.out.print(invitation);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextInt()) {
            System.out.print(invitation);
            scanner.next();
        }
       return scanner.nextInt();
    }
}
