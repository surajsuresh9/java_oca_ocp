package com.abstract_interfaces.flow_control;

public class ForLoopDemo {
    /*
            - Syntax of For Loop
                for(initialization; condition; update) {
                    // executes while condition is true
                }

            - Order of execution
                1. execute initialization statement(only once)
                2. check the condition
                3. if condition is true, execute the code, otherwise exit the loop
                4. execute update statement
                5. repeat step 2.

     */
    public static void main(String[] args) {
        // print 0 to 9 using for loop
        for (int i = 0; i <= 9; i++) {
            System.out.print(i + " ");
        }

        // it's possible to omit any one of the statements
        // but ; is still required to be in place

        // infinite loop
        // for(;;){}
        System.out.println();
        // more than 1 index can be used for the loop, separated by ,
        for (int i = 0, j = 0; (i + j) < 5; i++, j++) {
            System.out.println("i=" + i + ", j=" + j);
        }

        // for loop is often used to access the members of array (or collection)
        String[] cars = {"Ford", "Renault", "Fiat", "Kia"};

        // using traditional for loop
        for (int i = 0; i < cars.length; i++) {
            System.out.println(cars[i] + " ");
        }

        // using enhanced for loop
        System.out.println();
        for (String car : cars) {
            System.out.print(car + " ");
        }

        // In Java 17, for-each loop is used with LVTI
        System.out.println();
        for (var car : cars) {
            System.out.print(car + " ");
        }

    }
}
