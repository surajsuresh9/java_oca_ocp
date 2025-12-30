package com.localization.internationalization;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class InternationalizationDemo {
        /*
            What is localization?
                - you can make your program adaptable to multiple locales of geographic regions
                - these include:
                    - translating string to different languages
                    - outputting dates in the correct format
                    - outputting numbers in the correct format

                - localizing numbers
                    - different countries have different conventions when it comes to numbers
                    - localization can help to display the number in the appropriate locale format
                    - for this, we use NumberFormat factory methods

                 Method                                             Description
                 ============================================================================
                 getInstance()                                      general purpose formatter
                 getInstance(Locale locale)
                 ------------------------------------------------------------------------------------
                 getNumberInstance()                                same as getInstance()
                 getNumberInstance(Locale locale)
                 ------------------------------------------------------------------------------------
                 getCurrencyInstance()                              for formatting monetary amounts
                 getCurrencyInstance(Locale locale)
                 ------------------------------------------------------------------------------------
                 getPercentInstance()                               for formatting percentages
                 getPercentInstance(Locale locale)
                 ------------------------------------------------------------------------------------
                 getIntegerInstance()                               rounds decimal numbers before displaying
                 getIntegerInstance(Locale locale)
                 ------------------------------------------------------------------------------------
                 getCompactNumberInstance()                         returns compact number formatter
                 getInstance(Locale l, Style s)
                 ------------------------------------------------------------------------------------

                - DateTimeFormatter Factory Methods

                Method                                                                      Description
                ========================================================================================================
                ofLocalizedDate(FormatStyle dateStyle)                                      for formatting dates
                ofLocalizedTime(FormatStyle timeStyle)                                      for formatting times
                ofLocalizedDateTime(FormatStyle dateStyle, FormatStyle timeStyle)           for formatting dates and times
                ofLocalizedDateTime(FormatStyle dateTimeStyle)                              for formatting dates and times



        */

    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        System.out.println(locale);
        // en_US
        // language_country
        // (mandatory)_(optional)
        System.out.println(Locale.ITALIAN);// it
        System.out.println(Locale.ITALY); // it_IT
        System.out.println(new Locale("hi", "IN"));// hi_IN

        Locale myLocale = new Locale.Builder()
                .setLanguage("en")
                .setRegion("US")
                .build();
        System.out.println(myLocale);

        // get default locale
        System.out.println(Locale.getDefault());

        Locale locale1 = new Locale("fr");
        Locale.setDefault(locale1);
        System.out.println(Locale.getDefault());


        // formatting numbers
        double myNum = 1234.568;
        var us = NumberFormat.getInstance(Locale.US);
        System.out.println(us.format(myNum));
        var italy = NumberFormat.getInstance(Locale.US);
        System.out.println(italy.format(myNum));
        var canFrench = NumberFormat.getInstance(Locale.CANADA_FRENCH);
        System.out.println(canFrench.format(myNum));


        // formatting currencies
        double price = 12.3;
        var us1 = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println(us1.format(price));
        var uk = NumberFormat.getCurrencyInstance(Locale.UK);
        System.out.println(uk.format(price));
        var germany = NumberFormat.getCurrencyInstance(Locale.GERMANY);
        System.out.println(germany.format(price));

        // formatting percentages
        double discount = 0.151;
        var us3 = NumberFormat.getPercentInstance(Locale.US);
        System.out.println(us3.format(discount));
        var ger = NumberFormat.getPercentInstance(Locale.GERMANY);
        System.out.println(ger.format(discount));


        // parsing numbers
        try {
            String myNum1 = "15.72";
            var us4 = NumberFormat.getInstance(Locale.US);
            System.out.println(us4.parse(myNum1));
            var fr = NumberFormat.getInstance(Locale.FRANCE);
            System.out.println(fr.parse(myNum1));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        // parsing numbers with currency
        String price1 = "$23,567.890";
        var us5 = NumberFormat.getCurrencyInstance(Locale.US);
        try {
            double priceVal = (Double) us5.parse(price1);
            System.out.println(priceVal);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        // using CompactNumberFormat (JDK-17)
        int myNum2 = 8_765_432;
        var us6 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.SHORT);
        System.out.println(us6.format(myNum2));
        us6 = NumberFormat.getCompactNumberInstance(Locale.US, NumberFormat.Style.LONG);
        System.out.println(us6.format(myNum2));
        var ger2 = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.SHORT);
        System.out.println(ger2.format(myNum2));
        ger2 = NumberFormat.getCompactNumberInstance(Locale.GERMANY, NumberFormat.Style.LONG);
        System.out.println(ger2.format(myNum2));

        // localizing dates and times

        var dtf2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        var fr2 = new Locale("fr", "FR");
        var dt2 = LocalDateTime.of(2023, Month.FEBRUARY, 14, 9, 14, 57);
        System.out.println(dtf2.withLocale(fr2).format(dt2));
        var dtf3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
        var us7 = new Locale("us", "EN");
        System.out.println(dtf3.withLocale(us7).format(dt2));


        // displaying locale
        var hr = new Locale("hr", "HR");
        var price3 = 4.32;

        System.out.println("language:" + hr.getDisplayLanguage());
        System.out.println("country:" + hr.getDisplayCountry());
        System.out.println(NumberFormat.getCurrencyInstance(hr).format(price3));
    }
}
