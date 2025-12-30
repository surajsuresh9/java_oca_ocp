package com.abstract_interfaces.interfaces;

public interface Tetrapod {
    void eats();
}

interface Mammal2 {
    void eats();
}

class Dog implements Mammal2, Tetrapod {

    @Override
    public void eats() {
        System.out.println("Dog is eating");
    }
}


