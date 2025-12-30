package com.class_design.inheriting_methods;

public class Mammal2 {
    public String name = "Unknow";
}

class Dog2 extends Mammal2 {
    public String name = "Rex";

    public static void main(String[] args) {
        Dog2 d = new Dog2();
        Mammal2 m = d;
        System.out.println(d.name);
        System.out.println(m.name);
    }
}
