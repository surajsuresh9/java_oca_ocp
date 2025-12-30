package com.methods;

public class VarargsDemo {
    /*
      - method can accept any number of parameters of same type
        - a method can have at most one varargs argument
        - varargs argument must be the last parameter in the parameter list
    */

    void greet(String greeting, String... names) {
        for (String name : names) {
            System.out.println(greeting + " " + name);
        }
    }

    public static void main(String... args) {
        VarargsDemo vd = new VarargsDemo();
        vd.greet("Hello", "Alice", "Bob", "John");
        String[] names = {"Elijah", "Cathy", "Buck"};

        vd.greet("Hello", "Alice", "Bob", "John");
        System.out.println("************");

        // arrays can be passed
        vd.greet("Hello", names);

        // anonymous arrays CANNOT be passed
        // vd.greet("Hello", {"Elijah", "Cathy", "Buck"});

        System.out.println("************");
        // this is allowed
        vd.greet("Hello", new String[]{"Elijah", "Cathy", "Buck"});
    }
}
