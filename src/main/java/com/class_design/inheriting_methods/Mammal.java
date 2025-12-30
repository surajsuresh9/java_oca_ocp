package com.class_design.inheriting_methods;

public class Mammal {
    void speak() {
        System.out.println("Mammal is making sound");
    }
}


class Dog extends Mammal {

    @Override
    void speak() {
        System.out.println("Woof");
        super.speak();
    }

    public static void main(String[] args) {
//        Mammal mammal = new Mammal();
//        mammal.speak();
        Dog dog = new Dog();
        dog.speak();
    }
}