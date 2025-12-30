package com.date_time;

import java.time.*;

public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDate now1 = LocalDate.now();
        LocalTime now2 = LocalTime.now();
        LocalDateTime now3 = LocalDateTime.now();
        ZonedDateTime now4 = ZonedDateTime.now();
        System.out.println("now1: " + now1);
        System.out.println("now2: " + now2);
        System.out.println("now3: " + now3);
        System.out.println("now4: " + now4);

        // create local date
        LocalDate d1 = LocalDate.of(2022, Month.NOVEMBER, 10);
        System.out.println("d1: " + d1);
        LocalDate d2 = LocalDate.of(2022, 11, 10);
        System.out.println("d2: " + d2);

        // create local time
        LocalTime t1 = LocalTime.of(21, 50);
        LocalTime t2 = LocalTime.of(21, 50, 14);
        LocalTime t3 = LocalTime.of(21, 50, 14, 145);
        System.out.println("t1: " + t1);
        System.out.println("t2: " + t2);
        System.out.println("t3: " + t3);

        // create date local time
        LocalDateTime dt1 = LocalDateTime.of(2025, Month.DECEMBER, 30, 19, 9, 20, 145);
        System.out.println("dt1: " + dt1);

        LocalDateTime dt2 = LocalDateTime.of(d1, t3);
        System.out.println("dt2: " + dt2);

        // create zoned date-time
        ZoneId zoneId = ZoneId.of("Asia/Calcutta");
        ZonedDateTime z1 = ZonedDateTime.of(2025, 12, 30, 19, 10, 30, 123, zoneId);
        System.out.println(z1);
    }
}
