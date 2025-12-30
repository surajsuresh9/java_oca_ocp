package com.methods.static_modifier;

public class Item {
    static double tax = 0.2;

    public double getPrice(double inputPrice) {
        double margin = 0.05;
        return inputPrice * (1 + tax) * (1 + margin);
    }
}