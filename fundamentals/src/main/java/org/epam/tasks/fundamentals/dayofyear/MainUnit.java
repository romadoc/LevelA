package org.epam.tasks.fundamentals.dayofyear;

/**
 * Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
 * Осуществить проверку корректности ввода чисел.
 */
public class MainUnit {
    public void monthName(int number) {
        switch (number) {
            case 1:
                System.out.println(MonthOfTheYear.JANUARY);
                break;
            case 2:
                System.out.println(MonthOfTheYear.FEBRUARY);
                break;
            case 3:
                System.out.println(MonthOfTheYear.MARCH);
                break;
            case 4:
                System.out.println(MonthOfTheYear.APRIL);
                break;
            case 5:
                System.out.println(MonthOfTheYear.MAY);
                break;
            case 6:
                System.out.println(MonthOfTheYear.JUNE);
                break;
            case 7:
                System.out.println(MonthOfTheYear.JULY);
                break;
            case 8:
                System.out.println(MonthOfTheYear.AUGUST);
                break;
            case 9:
                System.out.println(MonthOfTheYear.SEPTEMBER);
                break;
            case 10:
                System.out.println(MonthOfTheYear.OCTOBER);
                break;
            case 11:
                System.out.println(MonthOfTheYear.NOVEMBER);
                break;
            case 12:
                System.out.println(MonthOfTheYear.DECEMBER);
                break;
            default:
                System.out.println("wrong number! it should be in range 1 - 12");
                break;
        }
    }
}
