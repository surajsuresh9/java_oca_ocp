package com.beyond_classes.nested_classes.static_inner_class;

public class State {
    static class Town {
        private int type = 1;
    }

    public static void main(String[] args) {
        var town = new Town();
//        var town = new State().new Town(); // if not static
        System.out.println(town.type);
    }
}
