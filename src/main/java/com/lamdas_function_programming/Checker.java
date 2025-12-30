package com.lamdas_function_programming;

// calling method reference on an object
@FunctionalInterface
public interface Checker {
    boolean check();
}

class MyClass3 {
    public static void main(String[] args) {
        String s = "John Wayne";
        Checker isEmpty = s::isEmpty;
        System.out.println(isEmpty.check());
    }
}
