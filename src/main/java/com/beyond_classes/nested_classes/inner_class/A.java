package com.beyond_classes.nested_classes.inner_class;

public class A {
    private String str = "Hello";

    // inner class
    protected class B {
        private static void printOut(String s) {
            System.out.println(s);
        }

        private void printHelloTwice() {
            // has access to private members of outer class
            printOut(str);
        }
    }

    public void printTwice() {
        var b = new B();
        b.printHelloTwice();
    }

    public static void main(String[] args) {
        var a = new A();
        a.printTwice();

        // inner class instantiation
        var b = new A().new B();
        b.printHelloTwice();

        // inner class method call
        new A().new B().printHelloTwice();
    }
}