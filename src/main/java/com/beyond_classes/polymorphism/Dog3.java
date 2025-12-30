package com.beyond_classes.polymorphism;

public class Dog3 {
    static int getSpeed() {
        return 20;
    }

    void printSpeed() {
        System.out.println(getSpeed());
    }
}


class GreatDane2 extends Dog3 {
    static int getSpeed() {
        return 35;
    }

    public static void main(String[] args) {
        new GreatDane2().printSpeed(); //
    }
}