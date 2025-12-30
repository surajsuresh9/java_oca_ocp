package com.class_design.initialization;

public class Item {
    private final double TAX;
    private final double price;

    public Item() {
        this.price = 12.5;
    }

    // instance initializer block
    {
        TAX = 0.2; // processed before constructor
    }
}
