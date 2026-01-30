package com.abstract_interfaces.flow_control;

public class SwitchDemo {
    /*
            - Syntax of Switch statement
                - curly brace is required {}
                - break statement is optional
                - default block is optional
                    - can be placed anywhere in statement
                - you don't need {} for the command block
                - allowed variable types: int (Integer), byte (Byte), Short (short), char (Character), String enum type
                    - not boolean, long, float, double

                // cases could be in the same line
            switch (a) {
            case 0: case 1: case 2:
                System.out.println("Good evening");
                break;
            default:
                System.out.println("Hello");
                break;
        }
    }

            - you can use yield in single statement (not a good practice)
            - switch expression can return different values
                - type will be determined in runtime
            - switch expression must handle all possible cases
            - if we use enum, we can list all possible values:

     */
    public static void main(String[] args) {
        greet(0);
        System.out.println("=========================");
        greet2(0);
        greet5(1, -1);
        int a = 3;
        String greeting = switch (a) {
            case 0, 1, 2 -> "Good day";
            case 3, 4 -> "Hi";
            default -> "Hello";
        };
        System.out.println(greeting);

        // yield can be used similar to return
        String greeting2 = switch (a) {
            case 0, 1, 2 -> {
                String str1 = "Good ";
                String str2 = "day";
                yield str1 + str2;
            }
            case 3, 4 -> "Hi";
            default -> "Hello";
        };
        System.out.println(greeting2);
    }

    static void greet(int a) {
        switch (a) {
            case 0:
                System.out.println("Good morning");
            case 1:
                System.out.println("Good afternoon");
            case 2:
                System.out.println("Good evening");
            default:
                System.out.println("Hello");
        }
    }

    // before Java 14
    static void greet2(int a) {
        switch (a) {
            case 0:
            case 1:
                System.out.println("Good afternoon");
            case 2:
                System.out.println("Good evening");
                break;
            default:
                System.out.println("Hello");
                break;
        }
    }


    // java 17
    static void greet3(int a) {
        switch (a) {
            case 0, 1, 2:
                System.out.println("Hi");
                break;
            case 3, 4:
                System.out.println("Hello");
                break;
        }
    }

    // preferred syntax -  java 17
    // '->' instead of ":"
    // no need of break
    static void greet4(int a) {
        switch (a) {
            case 0, 1, 2 -> System.out.println("Hi");
            case 3, 4 -> {
                System.out.println("Good ");
                System.out.print("morning");
            }
            default -> System.out.println("Default");
        }
    }

    // using yield
    static void greet5(int a, int b) {
        String greeting = switch (a) {
            case 0 -> "Good morning";
            case 1 -> {
                if (b > 0) {
                    yield "Good morning";
                } else {
                    yield "Good afternoon";
                }
            }
            case 2 -> "Good evening";
            default -> "Hello";
        };
        System.out.println(greeting);
    }

    void greet6(int a) {
        var printOut = switch (a) {
            case 0 -> "Good morning";
            case 1 -> 7;
            case 2 -> true;
            default -> 3.14;
        };
        System.out.println(printOut);
    }

    String getDirection(Compass value) {
        return switch (value) {
            case NORTH -> "Up";
            case SOUTH -> "Down";
            case EAST -> "Right";
            case WEST -> "Left";
        };
    }
}

enum Compass {
    NORTH, SOUTH, EAST, WEST
}