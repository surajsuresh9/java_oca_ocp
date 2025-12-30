package com.beyond_classes.polymorphism;

public class Dog2 {
    int getSpeed() {
        return 20;
    }

    void printSpeed() {
        System.out.println(getSpeed());
    }
}


class GreatDane extends Dog2 {
    @Override
    int getSpeed() {
        return 35;
    }

    public static void main(String[] args) {
        new GreatDane().printSpeed(); // 35, as getSpeed() is overridden in GreatDane subclass, this can be avoided by making getSpeed() final
    }
}