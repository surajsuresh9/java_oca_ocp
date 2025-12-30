package com.class_design.inheriting_methods;

public class D {
    public static void greet() {
        System.out.println("Hello");
    }
}

class E extends D {
    public static void greet() {
        System.out.println("Good afternoon");
    }

    public static void main(String[] args) {
        D.greet();
        E.greet();
    }
}
