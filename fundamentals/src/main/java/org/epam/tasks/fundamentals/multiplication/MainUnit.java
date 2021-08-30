package org.epam.tasks.fundamentals.multiplication;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Ввести целые числа как аргументы командной строки,
 * подсчитать их сумму (произведение) и вывести результат на консоль.
 */
public class MainUnit {
    private final String string = setString();
    private final ArrayList<Integer> list = createArrayOfInteger();

    public ArrayList<Integer> createArrayOfInteger() {
        String s = string.trim();
        String[] strings = s.split(" ");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s1 : strings) {
            if (s1.matches("[-+]?\\d+")) {
                arrayList.add(Integer.parseInt(s1));
            }
        }
        return arrayList;
    }

    public String setString() {
        String invitation = "type simple digits as string arguments >>";
        System.out.print(invitation);
        Scanner scanner = new Scanner(System.in);
        while (!scanner.hasNextLine()) {
            System.out.print(invitation);
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    public void print() {
        System.out.println("arguments: " + list);
    }

    public void calculateSumma() {
        int sum = 0;
        for (int i = -1; i < list.size() - 1; i++) {
            sum += list.get(i + 1);
        }
        System.out.println("Summa is " + sum);
    }

    public void calculateProduct() {
        int product = 1;
        for (int i = -1; i < list.size() - 1; i++) {
            product *= list.get(i + 1);
        }
        System.out.println("Product of multiplication is " + product);
    }

}
