package com.abstract_interfaces;

public abstract class Animal {
    public abstract void speak();
}

abstract class Mammal2 extends Animal {
    public abstract void walks();
}

class Dog2 extends Mammal2 {
    @Override
    public void walks() {
        System.out.println("Dog walks");
    }

    @Override
    public void speak() {
        System.out.println("Woof");
    }

    public static void main(String[] args) {
        Dog2 d = new Dog2();
        d.speak();
        d.walks();
    }
}

