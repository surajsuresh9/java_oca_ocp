package com.localization.resource_bundles;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class ResourceBundlesDemo {

    /*
            Resource Bundles
                - properties file which contains the locale-specific objects for the program
                    - basically a map with key, value pairs
                - the keys and values in property file are separated with by = or :
                - property file name is like this: Museum_en.properties
                    - <name_of_the_build>_<target_locale>.properties
                - to load a resource bundle:
                    - ResourceBundle.getBundle(bundle, locale)

             How to pick resource bundle
                - Museum_it_IT.properties (requested locale)
                - Museum_it.properties (requested language with no country)
                - Museum_en_US.properties (default locale)
                - Museum_en.properties (default locale with no country)
                - Museum.properties (bundle with no locale - default bundle)
                - MissingResourceException (if none of above is found)


     */

    public static void main(String[] args) {
        var enRb = ResourceBundle.getBundle("Museum", new Locale("en", "US"));
        var itRb = ResourceBundle.getBundle("Museum", new Locale("it", "IT"));

        System.out.println(enRb.getString("greeting") + " ! " + enRb.getString("open"));
        System.out.println(itRb.getString("greeting") + " ! " + itRb.getString("open"));


        // Formatting messages (import java.text.*)
        System.out.println(MessageFormat.format(itRb.getString("greetByName"), "Bruno", "Mario"));

        // using Properties class to define properties outside rb file
        var p = new Properties();
        p.setProperty("name", "Natural Museum");
        System.out.println("Welcome to " + p.getProperty("name"));

        // works like a HashMap with String key and value
    }
}
