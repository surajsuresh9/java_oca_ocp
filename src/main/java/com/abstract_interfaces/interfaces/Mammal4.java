package com.abstract_interfaces.interfaces;

public interface Mammal4 {
    void walks();

    void eats();

    default void sleeps() {
        System.out.println("A mammal sleeps");
    }
}

class Dog4 implements Mammal4 {

    @Override
    public void walks() {
        System.out.println("Dog walks");
    }

    @Override
    public void eats() {
        System.out.println("Dog eats");

    }
}

class Cat implements Mammal4 {

    @Override
    public void walks() {
        System.out.println("Cat walks");

    }

    @Override
    public void eats() {
        System.out.println("Cat eats");

    }
}
