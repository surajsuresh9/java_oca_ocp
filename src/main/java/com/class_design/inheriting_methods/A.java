package com.class_design.inheriting_methods;

import java.io.FileNotFoundException;
import java.io.IOException;

public class A {
    public void greet() throws IOException {
    }

    public void sayHello() {
    }

    public void leave() throws FileNotFoundException {
    }
}

class B extends A {
    @Override
    public void greet() throws FileNotFoundException {
    }

    // compiler error
//    @Override
//    public void sayHello() throws IOException {
//    }
//
//    @Override
//    public void leave() throws IOException {
//    }
}
