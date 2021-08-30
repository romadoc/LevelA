package org.epam.tasks.fundamentals.greetuser;

import java.util.Scanner;

/**
 * Приветствовать любого пользователя при вводе его имени через командную строку.
 */

public class Name {
    private String getName;

    private String setName() {
        String invitation = "Type you name >>";
        System.out.print(invitation);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) {
            scanner.nextLine();
            System.out.print(invitation);
        }
        String takenName = scanner.nextLine();
        if (takenName.length() > 2 && takenName.length() < 20) {
            getName = takenName;
        } else {
            setName();
        }
        return getName;
    }

    public void printGreeting() {
        System.out.println("Hello " + setName() + "! Nice to meet you!");
    }
}
