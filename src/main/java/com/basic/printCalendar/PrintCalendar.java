package com.basic.printCalendar;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 打印当月日历
 * Mon Tue Wed Thu Fri Sat Sun
 *       1   2   3   4   5   6
 *   7*  8   9  10  11  12  13
 *  14  15  16  17  18  19  20
 *  21  22  23  24  25  26  27
 *  28  29  30
 */
public class PrintCalendar {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();

        date = date.minusDays(day - 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int value = dayOfWeek.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }

        while (month == date.getMonthValue()) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (day == date.getDayOfMonth()) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }

        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }


    }
}
