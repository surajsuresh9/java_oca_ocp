package com.abstract_interfaces.interfaces;

public interface Tetrapod2 {
    void eats();
}

interface Mammal3 {
    int eats();
}

// will result in compiler error
// method eats() clashes

//class Dog2 implements Mammal3, Tetrapod2 {

//    @Override
//    public void eats() {
//    }
//
//    @Override
//    public int eats() {
//        return 0;
//    }


//}


