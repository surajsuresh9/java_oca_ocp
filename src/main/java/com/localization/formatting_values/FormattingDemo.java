package com.localization.formatting_values;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class FormattingDemo {
    /*
            Formatting Numbers
                - to format numbers we have to use NumberFormat interface
                - we have already learned about to methods from this interface
                    public final String format(double number)
                    public final String format(long number)
                - now we introduce the concrete class DecimalFormat, which includes the
                  constructor that takes a String pattern
                    public DecimalFormat(String pattern)
                - to create a pattern, we need to know to formatting characters:
                    # - omit position if no digit exists for it (e.g. $2.2)
                    0 - put 0 in position if no digit exists for it (e.g. $002.20)

            Formatting Dates and Times
                - to display standard formats Java provides a class called DateTimeFOrmatter
                - predefined formats can be used (e.g. ISO_LOCAL)DATE)
                - to create your own String format use of Pattern method
                    - used with common date/ time symbols


               Symbol                       Meaning                         Example
               =======================================================================
               y                            Year                            23, 2023
               M                            Month                           2, 02, Feb, February
               d                            Day                             7, 07
               h                            Hour                            8, 08
               m                            Minute                          25
               S                            Second                          17
               a                            a.m/ p.m                        AM, PM
               z                            Time Zone name                  Central European Time, CET
               Z                            Time Zone offset                -600
     */

    public static void main(String[] args) {
        double num = 1234.56789;

        NumberFormat f1 = new DecimalFormat("###,###,###.0");
        System.out.println(f1.format(num));

        NumberFormat f2 = new DecimalFormat("000,000,000000");
        System.out.println(f2.format(num));

        NumberFormat f3 = new DecimalFormat("My Balance: $#,###,###.##");
        System.out.println(f3.format(num));

        // date - time
        LocalDate currDate = LocalDate.of(2026, Month.JANUARY, 12);
        System.out.println("Day of Week: " + currDate.getDayOfWeek());
        System.out.println("Year: " + currDate.getYear());
        System.out.println("Day of Year: " + currDate.getDayOfYear());

        LocalTime currTime = LocalTime.of(12, 14, 45, 100);
        System.out.println(currTime);

        LocalDateTime currDateTime = LocalDateTime.of(currDate, currTime);
        System.out.println(currDateTime);
        System.out.println(currDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println(currTime.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println(currDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        // creating custom formats
        var f11 = DateTimeFormatter.ofPattern("dd.MM.yyyy.hh:mm:ss");
        System.out.println(currDateTime.format(f11));
        var f22 = DateTimeFormatter.ofPattern("MMMM-dd-yy HH:mm:ss");
        System.out.println(currDateTime.format(f22));
        var f33 = DateTimeFormatter.ofPattern("MMMM-dd-yy HH:mm:ss a");
        System.out.println(currDateTime.format(f33));

        // alternate
        System.out.println(f33.format(currDateTime));

        var f44 = DateTimeFormatter.ofPattern("'Date:'dd.MM.yy. '| Time:' hh:mm:ss a");
        System.out.println(currDateTime.format(f44));
        var f55 = DateTimeFormatter.ofPattern("MMM-dd-yyyy 'at' HH'h'm'm'ss's'");
        System.out.println(currDateTime.format(f55));

        // NOTE: spaces can be added within or out of the single quotes
    }
}
