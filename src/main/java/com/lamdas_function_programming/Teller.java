package com.lamdas_function_programming;

@FunctionalInterface
public interface Teller {
    String tellName(String name);
}

class TellerDemo {
    public static void main(String[] args) {
        Teller teller = String::new;
        System.out.println(teller.tellName("John Wayne"));
    }
}
