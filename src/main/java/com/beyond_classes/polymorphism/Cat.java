package com.beyond_classes.polymorphism;

public class Cat {
    protected int age = 5;

    public static boolean isWild() {
        return false;
    }
}

class Tiger extends Cat {
    protected int age = 7;

    public static boolean isWild() {
        return true;
    }

    public static void main(String[] args) {
        Tiger dave = new Tiger();
        Cat rave = dave;
        System.out.println("age: " + dave.age);
        System.out.println(dave.isWild());
        System.out.println("age: " + rave.age);
        System.out.println(rave.isWild());
    }
}