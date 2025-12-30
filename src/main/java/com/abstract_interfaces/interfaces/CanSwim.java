package com.abstract_interfaces.interfaces;

interface Mammal {
    int eats();
}

public interface CanSwim extends Mammal {
    int swim();
}

class Elephant implements CanSwim, Mammal {

    @Override
    public int swim() {
        return 5;
    }

    @Override
    public int eats() {
        return -1;
    }
}
