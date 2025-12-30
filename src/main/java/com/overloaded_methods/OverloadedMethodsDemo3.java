package com.overloaded_methods;

public class OverloadedMethodsDemo3 {

    void greet(Number o) {
        System.out.println("Hi");
    }

    void greet(CharSequence o) {
        System.out.println("Hello");
    }

    void greet(Object o) {
        System.out.println("Good day");
    }

    public static void main(String[] args) {
        OverloadedMethodsDemo3 o = new OverloadedMethodsDemo3();

        // Java will also look for supertypes
        o.greet(3.14);
        // wrap 3.14 to Double, which implements Number

        o.greet("Luke");
        // String implements CharSequence

        o.greet(new String[]{"Luke"});
        // Object

        /*
            Note:
                The order Java uses for finding teh right overloaded methods
                    1. Exact match by type
                    2. Larger primitive type
                    3. Auto boxed type
                    4. Varargs
         */

    }
}
