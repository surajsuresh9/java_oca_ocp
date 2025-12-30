package com.date_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeDemo2 {
    public static void main(String[] args) {
    /* date/time methods
         - LocalDate, LocalDateTime
            - plusYears(), plusMonths(), plusWeeks(), plusDays()
            - minusYears(), minusMonths(), minusWeeks(), minusDays()

         - LocalTime, LocalDateTime
            - plusDays(), plusMinutes(), plusSeconds(), plusNanos()
            - minusDays(), minusMinutes(), minusSeconds(), minusNanos()

         - LocalDate, LocalTime, LocalDateTime
            - isBefore(), isAfter()
     */

        LocalDate date = LocalDate.of(2025, Month.DECEMBER, 30);
        System.out.println(date);
        LocalTime time = LocalTime.of(17, 30);
        System.out.println(time);
        LocalDateTime localDateTime = LocalDateTime.of(date, time);
        System.out.println(localDateTime);
        localDateTime = localDateTime.plusDays(2);
        localDateTime = localDateTime.plusHours(2);
        localDateTime = localDateTime.plusSeconds(15);
        System.out.println(localDateTime);

        localDateTime = localDateTime.minusDays(5).plusHours(3).minusSeconds(40);
        System.out.println(localDateTime);

        // date and time classes are immutable
        LocalDate localDate = LocalDate.of(2025, Month.DECEMBER, 30);
        localDate.plusMonths(3);
        System.out.println(localDate);

        // isBefore() and isAfter()
        LocalDate date1 = LocalDate.of(2025, Month.DECEMBER, 1);
        LocalDate date2 = LocalDate.of(2025, Month.NOVEMBER, 1);
        System.out.println("date1.isAfter(date2): " + date1.isAfter(date2));
        System.out.println("date1.isAfter(date2): " + date1.isBefore(date2));


    }
}
