package com.abstract_interfaces;

public abstract class Mammal {
    public abstract void speak();
}

class Dog extends Mammal{

    @Override
    public void speak() {
        System.out.println("Woof");
    }
}

class Cat extends Mammal{

    @Override
    public void speak() {
        System.out.println("Meow");
    }
}