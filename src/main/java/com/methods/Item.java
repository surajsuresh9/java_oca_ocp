package com.methods;

public class Item {
    public double tax = 0.2;

    public double getPrice(double inputPrice) {
        final double margin;
        margin = 0.05;
        // cannot be changed again
        // margin = 0.04;
        return inputPrice * (1 + tax) * (1 + margin);
    }
}
