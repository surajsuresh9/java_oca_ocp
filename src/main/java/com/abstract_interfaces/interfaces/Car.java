package com.abstract_interfaces.interfaces;

public interface Car {
    int distanceWithFullTank(int tankVolume);

    int MAX_WEIGHT = 2000;

    static int getMaxSpeed() {
        return 100;
    }
}

/*
    - Implicit keywords

 public abstract interface Car {
    public abstract int distanceWithFullTank(int tankVolume);
    public static final int MAX_WEIGHT = 2000;
}

*/


interface Ford {
    String getColor();
}

class FordModelT implements Car, Ford {

    @Override
    public int distanceWithFullTank(int tankVolume) {
        return tankVolume * 9;
    }

    @Override
    public String getColor() {
        return "Black";
    }

    public int getMaxSpeed() {
        return Car.getMaxSpeed();
    }
}