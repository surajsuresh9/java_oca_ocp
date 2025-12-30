package com.lamdas_function_programming;

@FunctionalInterface
public interface Animal {
    void speak();
}

//class Dog implements Animal {
//
//    @Override
//    public void speak() {
//        System.out.println("Woof!");
//    }
//}

class MyClass {
    public static void main(String[] args) {
        // old way
        // anonymous inner class
        Animal animal = new Animal() {
            @Override
            public void speak() {
                System.out.println("Woof!");
            }
        };
        animal.speak();

        // new way
        // lambda expression
        Animal dogImpl = () -> System.out.println("Woof Woof!!");
        Animal catImpl = () -> System.out.println("Meow Meow!");
        Animal cowImpl = () -> System.out.println("Mow Mow!");
        dogImpl.speak();
        catImpl.speak();
        cowImpl.speak();

    }
}