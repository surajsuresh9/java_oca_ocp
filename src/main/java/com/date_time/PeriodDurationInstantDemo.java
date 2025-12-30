package com.date_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class PeriodDurationInstantDemo {
    public static void main(String[] args) throws InterruptedException {
        // Period can be used only with LocalDate and LocalDateTime
        Period p1 = Period.ofYears(2);
        System.out.println(p1);
        Period p2 = Period.ofMonths(3);
        System.out.println(p2);
        Period p3 = Period.ofWeeks(1);
        System.out.println(p3);
        Period p4 = Period.ofDays(11);
        System.out.println(p4);
        Period p5 = Period.of(2, 2, 15);
        System.out.println(p5);

        // Period is used with plus/ minus ond ate

        Period period = Period.of(1, 2, 5);
        LocalDate date = LocalDate.of(2025, Month.DECEMBER, 30);
        date = date.plus(period);
        System.out.println(date);
        date = date.minus(period);
        System.out.println(date);

        // Duration can be used with LocalTime and LocalDateTime
        Duration d1 = Duration.ofDays(3);
        System.out.println(d1);
        Duration d2 = Duration.ofHours(2);
        System.out.println(d2);
        Duration d3 = Duration.ofMinutes(45);
        System.out.println(d3);
        Duration d4 = Duration.ofSeconds(10);
        System.out.println(d4);
        Duration d5 = Duration.ofMillis(240);
        System.out.println(d5);
        Duration d6 = Duration.ofNanos(2340);
        System.out.println(d6);

        // using ChronoUnit
        Duration d7 = Duration.of(3, ChronoUnit.HALF_DAYS);
        System.out.println(d7);
        Duration d8 = Duration.of(3, ChronoUnit.DAYS);
        System.out.println(d8);
        Duration d9 = Duration.of(3, ChronoUnit.HOURS);
        System.out.println(d9);
        Duration d10 = Duration.of(30, ChronoUnit.MINUTES);
        System.out.println(d10);
        Duration d11 = Duration.of(45, ChronoUnit.SECONDS);
        System.out.println(d11);
        Duration d12 = Duration.of(240, ChronoUnit.MILLIS);
        System.out.println(d12);
        Duration d13 = Duration.of(2503, ChronoUnit.NANOS);
        System.out.println(d13);

        // ChronoUnit can also be used to determine how far apart two times are
        LocalTime t1 = LocalTime.of(17, 30);
        LocalTime t2 = LocalTime.of(20, 45);
        System.out.println(ChronoUnit.HOURS.between(t1, t2));
        System.out.println(ChronoUnit.MINUTES.between(t1, t2));

        // Durations are used with plus/ minus on time
        LocalTime time = LocalTime.of(17, 30);
        System.out.println(time);
        Duration d = Duration.ofMinutes(45);
        System.out.println(d);
        time = time.plus(d);
        System.out.println(time);

        // Instant is used to record timestamps in applications
        Instant now = Instant.now(); // System time
        System.out.println(now);

        Instant before = Instant.now();
        Thread.sleep(250);
        Instant after = Instant.now();
        Duration between = Duration.between(before, after);
        System.out.println(between.toMillis() + " ms");

        // Instant uses a long representing epoch-seconds
        // which are measured from the standard Java epoch
        // of 1970-01-01T00:00:00z

        // converting ZonedTimeDate to Instant
        ZoneId zoneId = ZoneId.of("Asia/Calcutta");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(2025, 12, 31, 0, 0, 0, 0, zoneId);
        Instant i = zonedDateTime.toInstant();
        System.out.println(i);


    }
}
