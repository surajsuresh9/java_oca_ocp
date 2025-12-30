package com.overloaded_methods;

public class OverloadedMethodsDemo2 {

    void greet(Short x) {
        System.out.println("Hi");
    }

    void greet(Integer x) {
        System.out.println("Hello");
    }

    void greet(String x) {
        System.out.println("Good Afternoon");
    }

    void greet(Object o) {
        System.out.println("Good day");
    }


    public static void main(String[] args) {
        OverloadedMethodsDemo2 o = new OverloadedMethodsDemo2();

        o.greet(2.3);
        // wraps 2.3 in Double, which extends Object -> "Good day"

        o.greet((short) 2);
        // wraps (short)2 -> Short

        o.greet((byte) 2);
        // byte -> Byte -> Object

        o.greet("John Wayne");
    }
}
