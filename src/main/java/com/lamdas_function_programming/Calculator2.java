package com.lamdas_function_programming;

@FunctionalInterface
public interface Calculator2 {
    double path(double t);
}

class Gravity {
    public static double freeFall(double t) {
        final double g = 9.81;
        return 0.5 * g * t * t;
    }
}


class Demo {
    public static void main(String[] args) {
        Calculator2 methRef = Gravity::freeFall;
        System.out.println(methRef.path(10));
    }
}