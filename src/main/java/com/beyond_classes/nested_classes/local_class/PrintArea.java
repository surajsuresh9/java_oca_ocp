package com.beyond_classes.nested_classes.local_class;

public class PrintArea {
    private int a = 10;

    public void calculateArea() {
        final int b = 15;

        // method local class
        class Computer {

            void multiply() {
                System.out.println(a * b);// can access both a and b
            }
        }

        var computer = new Computer();// goes out of scope when we exit the method
        computer.multiply();
    }

    public static void main(String[] args) {
        var printArea = new PrintArea();
        printArea.calculateArea();
    }
}
