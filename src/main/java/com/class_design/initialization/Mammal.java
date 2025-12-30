package com.class_design.initialization;

public class Mammal {
    static {
        System.out.println("Hello");
    }

    {
        System.out.println("Good afternoon");
    }
}

class Dog extends Mammal {
    private String name = "Rex";

    {
        System.out.println("Name: " + name);
    }

    private static int i = 0;

    static {
        System.out.println(i);
    }

    {
        i++;
        System.out.println(i);
    }

    public Dog() {
        System.out.println("Woof");
    }

    public static void main(String[] args) {
        System.out.println("I'm the main one");
        new Dog();
    }

    // Hello
    // 0
    // I'm the main one
    // Good afternoon
    // Name: " + Rex
    // 1
    // Woof

}
