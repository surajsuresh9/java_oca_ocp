package com.class_design.inheritance;

public class Dog extends Mammal {
    private String name;
    private int age;

    public Dog() {
        this("Chip", 1);
        System.out.println("Woof");
    }


    public Dog(String name, int age) {
        super(age);
        this.name = name;
        this.age = age;
    }

    public Dog(String name) {
        super(0);
        this.name = name;
    }

    public Dog(int age) {
        super(age);
        this.age = age;
    }

    public Dog(boolean isPuppy, String name) {
        super(0);
        this.age = isPuppy ? 0 : -1;
        this.name = name;
    }

    void setNameAndAge(String name, int age) {
        super.name = name;
        setAge(age);
    }

    void barks() {
        System.out.println("Dog " + name + "(" + getAge() + ")" + " says Woof!");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("Rex", 5);
        Dog puppy = new Dog(true, "Rex");
        dog.setNameAndAge("Rex", 5);
        dog.barks();
    }
}
