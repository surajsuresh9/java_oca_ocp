package com.beyond_classes.polymorphism;

public class Dog {

    boolean canRun() {
        return true;
    }
}

interface CanRun {
    boolean canRunFast();
}

class ShihTzu extends Dog implements CanRun {

    public int weight = 6;

    @Override
    public boolean canRunFast() {
        return false;
    }

    public static void main(String[] args) {
        ShihTzu shihTzu1 = new ShihTzu();
        System.out.println(shihTzu1.weight);

        Dog shihTzu2 = shihTzu1;
        System.out.println(shihTzu2.canRun());

        CanRun shihTzu3 = shihTzu1;
        System.out.println(shihTzu3.canRunFast());
    }
}
