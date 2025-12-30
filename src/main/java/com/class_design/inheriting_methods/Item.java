package com.class_design.inheriting_methods;

public class Item {

    protected Number calculatePrice(float price) {
        return price + price * 0.2;
    }
}

class Shoe extends Item {

    @Override
    public Double calculatePrice(float price) {
        return (price + price * 0.2) * 1.05;
    }

    public static void main(String[] args) {
        System.out.println(new Item().calculatePrice(100));
        System.out.println(new Shoe().calculatePrice(100));
    }
}
