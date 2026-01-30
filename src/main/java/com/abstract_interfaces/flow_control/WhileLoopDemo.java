package com.abstract_interfaces.flow_control;

public class WhileLoopDemo {
    /*
            - Syntax of while loop
                while(condition) {
                    // executes while condition is true
                }
     */
    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }

        // it's possible that body is never executed
        int a = 5, b = 7;
        while (a > b) {
            System.out.println("Hello");
            // never executes
        }
//
//        // infinite loop
//        while (a < b) {
//            System.out.println("Hello");
//        }
//
//        // simplest inifinte loop
//        while (true){}

        // break statements exits the loop
        int n = 0;
        while (true) {
            if (n == 9) break;
            n++;
        }

        // nested loops
        i = 0;
        int j = 0;

        while (i < 3) {
            i++;
            j = 0;
            while (j < 3) {
                j++;
                System.out.print("(i: " + i + ", " + "j: " + j + ") ");
            }
        }

        // using break in nested loops
//        i = 0;
//        j = 0;
//        while (true) {
//            i++;
//            j = 0;
//            while (true) {
//                j++;
//                System.out.print("(i: " + i + ", " + "j: " + j + ") ");
//                if (j == 3) break;// break exits the inner loop, the outer loop is still an infinite loop
//            }
//        }

        // using break in nested loops, with labels
        i = 0;
        j = 0;
        OUTER_LOOP:
        while (true) {
            i++;
            j = 0;
            INNER_LOOP:
            while (true) {
                j++;
                System.out.print("(i: " + i + ", " + "j: " + j + ") ");
                if (j == 3) break OUTER_LOOP;
            }
        }

        // continue skips one iteration of the loop
        // task: print all even nos b/w 0 and 20
        i = 0;
        while (i <= 20) {
            i++;
            if (i % 2 != 0) {
                continue;
            }
            System.out.print(i + " ");
        }

        printPairs();

    }

    // return statements breaks the execution of the loop (exits the method)
    static void printPairs() {
        int i = 0, j = 0;
        while (true) {
            i++;
            while (true) {
                j++;
                System.out.print("(i: " + i + ", " + "j: " + j + ") ");
                if (j == 4) {
                    return;// exits the method
                }
            }
        }
    }
}
