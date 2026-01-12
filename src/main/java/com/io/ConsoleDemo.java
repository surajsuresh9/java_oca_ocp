package com.io;

import java.io.Console;
import java.util.Arrays;

public class ConsoleDemo {
    /*
            Console Class
                - designed for interaction with the user
                - this class is Singleton
                    - using factory method we create one and only instance of this class
                - the constructors of Console class are private
                    - i.e. created using factory methods, not with new keyword
     */

    public static void main(String[] args) {
        Console console = System.console();
        if (console != null) {
            String myName = console.readLine("What is your name?");
            console.format("Hello %s!%n", myName);
            console.writer().println("-".repeat(30));

            char[] password = console.readPassword("Please enter your password");
            char[] repeatPassword = console.readPassword("Please verify the password");
            if (Arrays.equals(password, repeatPassword)) {
                console.printf("Password successfully set.%n");
            } else {
                console.printf("ERROR! passwords don't match!.%n");
            }
        } else {
            System.err.println("Console unavailable!");
        }
    }
}
