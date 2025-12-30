package com.methods;

public class MethodDemo {
    public static void main(String[] args) {
        Item item = new Item();
        System.out.println(item.getPrice(100));
        Item specialItem = new Item();
        specialItem.tax = 0.1;
        System.out.println(specialItem.getPrice(100));
    }
}

