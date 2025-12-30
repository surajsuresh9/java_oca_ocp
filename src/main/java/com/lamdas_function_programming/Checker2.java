package com.lamdas_function_programming;

// calling method reference on a parameter
@FunctionalInterface
interface Checker2 {
    boolean check(String s);
}

class MyClass4 {
    public static void main(String[] args) {
        Checker2 isEmpty2 = String::isEmpty;
        System.out.println(isEmpty2.check(" "));
    }
}

