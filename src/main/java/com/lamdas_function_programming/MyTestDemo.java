package com.lamdas_function_programming;

import java.util.function.Predicate;

public class MyTestDemo {
    public static void main(String[] args) {
        Predicate<Integer> greaterThan10 = (Integer n) -> {
            return n > 10;
        };

        System.out.println("9 greaterThan10: " + greaterThan10.test(9));
        System.out.println("11 greaterThan10: " + greaterThan10.test(11));

        Predicate<Integer> evenNum = n -> n % 2 == 0;
        myProbe(10, evenNum);
        myProbe(11, evenNum);
    }

    static void myProbe(int n, Predicate<Integer> predicate) {
        if (predicate.test(n)) {
            System.out.println("test has passed");
        } else {
            System.out.println("test has failed");
        }
    }
}
