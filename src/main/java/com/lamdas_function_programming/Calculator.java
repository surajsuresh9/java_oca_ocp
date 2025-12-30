package com.lamdas_function_programming;

@FunctionalInterface
public interface Calculator {
    int minimum(int a, int b);
}


class Test {
    public static void main(String[] args) {
        Calculator minLambda = (a, b) -> Math.min(a, b);
        Calculator minMethRef = Math::min;

        System.out.println(minLambda.minimum(1, 3));
        System.out.println(minMethRef.minimum(1, 3));
    }
}