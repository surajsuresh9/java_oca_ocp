package com.abstract_interfaces.flow_control;

public class IfElseDemo {
    /*
            if (exp-1) {
                // block of code#1
            } else if(exp-2) {
                // block of code#2
            } else if(exp-3) {
                // block of code#3
            } else {
                // block of code
            }

        - arg is boolean expression
        - block evaluates if expression is true
        - else-if block is optional
        - there can be as many as you want
        - else block is optional
        - if there is only one command in the block, you can omit {}

     */
    public static void main(String[] args) {
        int a = 5, b = 10, c;
        String s;
        if (a > 3 && b < 9) {
            s = "A";
            c = 1;
        } else if (a < 3 || a + b <= 15) {
            s = "C";
            c = 3;
        } else {
            s = "D";
            c = 4;
        }

        System.out.println("Result: " + s + c);
    }
}
