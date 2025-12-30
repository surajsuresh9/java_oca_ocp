package com.beyond_classes.nested_classes.inner_class;

public class A1 {
    private int t = 1;

    class B1 {
        private int t = 2;

        class C1 {
            private int t = 3;

            void printT() {
                System.out.println("t: " + t);
                System.out.println("this.t: " + this.t);
                System.out.println("B1.this.t: " + B1.this.t);
                System.out.println("A1.this.t: " + A1.this.t);
            }
        }
    }

    public static void main(String[] args) {
        new A1().new B1().new C1().printT();
    }
}
