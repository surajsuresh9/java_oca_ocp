package com.lamdas_function_programming;

public class MethodReferenceDemo {
    /*
            Lambda                                      Method Reference
            =================================================================
            s -> System.out.println(s);                 System.out::println
            (a,b) -> Math.min(a,b)                      Math::min
            t -> Gravity.freefall(t)                    Gravity::freefall
            () -> s.isEmpty()                           s::isEmpty()
            s -> s.isEmpty()                            String::isEmpty()
     */
}

@FunctionalInterface
interface Animal2 {
    void shout(String s);
}

class MyClass2 {
    public static void shout(String s, Animal2 a) {
        a.shout(s);
    }

    public static void main(String[] args) {
        Animal2 animal2 = System.out::println;
        shout("Woof!", animal2);
    }
}