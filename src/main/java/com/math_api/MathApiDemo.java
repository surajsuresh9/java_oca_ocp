package com.math_api;

public class MathApiDemo {
    public static void main(String[] args) {
        // min() and max()
        int a = Math.max(3, 11);
        System.out.println("Max is: " + a);

        int b = Math.min(2, -4);
        System.out.println("Min is: " + b);

        // you can compare all types of numbers, but beware of auto-casting
        long l = 5;
        b = 3;
        int c = (int) Math.max(l, b);

        // round() -> takes decimal number and returns integral number
        // if parameter is float, return type will be int
        // if parameter is double, return type will be long

        double d = 2.56;
        long a1 = Math.round(d);
        System.out.println("rounded 2.56: " + a1);
        int b1 = (int) Math.round(d);
        System.out.println("rounded 2.56 and casted to int: " + b1);

        // ceil() and floor()
        // takes any number and always returns double

        double r = Math.ceil(2.45);
        System.out.println("ceil 2.45: " + r);
        r = Math.floor(2.45);
        System.out.println("floor 2.45: " + r);
        r = Math.floor(2.99);
        System.out.println("floor 2.99: " + r);

        // exponent
        // takes any number, return double
        double p = Math.pow(2, 5);
        System.out.println("2^5: " + p);
        p = Math.pow(25, 0.5);
        System.out.println("25^0.5: " + p);

        // random numbers
        double rand = Math.random();
        System.out.println(rand);
        // random number between 0 and 1.0 (not included)

    }
}
