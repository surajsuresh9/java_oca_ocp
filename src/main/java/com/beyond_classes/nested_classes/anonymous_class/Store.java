package com.beyond_classes.nested_classes.anonymous_class;

public class Store {

    abstract class Sale {
        abstract int discount();
    }

    public int newPrice(int oldPrice) {
        // sale is an instance of anonymous class with the
        // implementation of discount() from abstract class Sale
        Sale sale = new Sale() {
            @Override
            int discount() {
                return 0;
            }
        };
        return oldPrice - sale.discount();
    }
}


class Dog {
    // empty interface
    interface Eats {
    }

    Eats eating = new Eats() {
    }; //OK

    // eating is not an instance of the interface (not allowed!)
    // but the instance of the anonymous class {}; implementing the interface
}