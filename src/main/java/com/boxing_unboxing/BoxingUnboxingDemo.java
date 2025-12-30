package com.boxing_unboxing;

public class BoxingUnboxingDemo {
    /*
        - Boxing:
            - converting primitive to Wrapper class (int -> Integer)
        - Unboxing:
            - converting Wrapper class to primitive (Integer -> int)

         - Java will auto cast a smaller primitive into a larger one
         - But Java will not do auto cast and auto box at the same time
           i.e. int -> long       OK
                int -> Long       Not OK
                    int -> long
                    long -> Long
                    or
                    Long l = Long.valueOf(x)
                    Long l = Long.valueOf((long)x)


         - If we need both auto casting and auto boxing, one of the operations should be done
           manually or both


     */
    public static void main(String[] args) {

        // Explicit casting

        // Integer -> int
        int a = 3;
        System.out.println("Boxed value: " + Integer.valueOf(a));

        // int -> Integer
        Integer c = Integer.valueOf(6);
        System.out.println("Unboxed value: " + c.intValue());

        // Implicit casting
        // Autoboxing
        // int -> Integer
        int a1 = 3;
        Integer b1 = a1;

        // Auto unboxing
        // Integer -> int
        int c1 = b1;

    }
}
