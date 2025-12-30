package com.abstract_interfaces.interfaces;

public interface Car2 {
    default int getMaxSpeed() {
        return 100;
    }
}

interface Truck2 {
    default int getMaxSpeed() {
        return 70;
    }
}

class Van implements Car2, Truck2 {
    @Override
    public int getMaxSpeed() {
        return 80;
    }

    public int getMaxSpeedCar() {
        return Car2.super.getMaxSpeed();
    }
}
