package com.overloaded_methods;

public class OverloadedMethodsDemo {
    void greet(int x) {
        System.out.println("Hello");
    }

    void greet(double x) {
        System.out.println("Good Afternoon");
    }

    void greet(int x, int y) {
        System.out.println("Good day");
    }

    public static void main(String[] args) {
        OverloadedMethodsDemo o = new OverloadedMethodsDemo();
        o.greet(10);
        o.greet(10, 20);
        o.greet(10.0);

        // if passing argument doesn't exactly match the parameter type
        // Java will pick the most similar version of the method

        short a = 2;
        o.greet(a);
    }
}
