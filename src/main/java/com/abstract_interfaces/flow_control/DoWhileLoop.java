package com.abstract_interfaces.flow_control;

public class DoWhileLoop {
    /*
        - Syntax of do/ while loop
            do {
                // executes while condition is true
            } while (condition)

        - the main difference compared to while loop
            - block of code will be executed at least once
            - semicolon ; is not need at the end
     */
    public static void main(String[] args) {
        // print out 0 to 9
        int i = 0;
        do {
            System.out.print(i + " ");
            i++;
        } while (i < 10);
    }
}
