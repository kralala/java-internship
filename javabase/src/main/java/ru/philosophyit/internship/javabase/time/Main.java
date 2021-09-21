package ru.philosophyit.internship.javabase.time;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.time.LocalDate;

public class Main {
    public static void main(String ...args) {
        System.out.println(DateTimeFormatter.ISO_INSTANT.format(Calendar.getInstance().toInstant()));

        // Отобразите календарь текущего месяца в консоли
        // например:
        // пн вт ср чт пт сб вс
        // 30 31 1  2  3  4  5
        // и т.д.

        LocalDate currentDate = LocalDate.now().plusMonths(0); // плюс месяцы для теста
        showCalendar(currentDate);
    }

    private static void showCalendar(LocalDate currentDate) {

        // База календаря
        System.out.println();
        System.out.println(" " + currentDate.getMonth().toString().toLowerCase() + " " + currentDate.getYear());

        System.out.println(" mo tu we th fr sa su");

        // Отступы для первого дня
        LocalDate startingDay = currentDate.withDayOfMonth(1);
        for (int i = 0; i < startingDay.getDayOfWeek().getValue() - 1; i++) {
            System.out.print("   ");
        }

        // Заполнение календаря
        for (int i = 1; i <= currentDate.lengthOfMonth(); i++) {
            System.out.printf("%3d", i);
            if ((i + startingDay.getDayOfWeek().getValue() - 1) % 7 == 0) {
                System.out.println();
            }
        }

    }
}
