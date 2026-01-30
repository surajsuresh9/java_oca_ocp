package com.building_blocks;

public class VariablesDemo {
    /*
            - Variables
                - 3 types of variables
                    - local variable - exist only within the block of code { ... }
                    - instance variables (fields) - defined within the specific instance of the object
                    - class variables - belong to a class and is shared with all instances of the class
                        - marked with keyword static

                    - instance and class variables don't require initialization
                    - assume the default values of their type

                - local variables must be initialized before use

     */

//    int doesNotCompile() {
//        int a = 5;
//        int b;
//        return a + b; // trying to use uninitialized variable b
//    }

    int doesCompile() {
        int a = 5;
        int b = 10;
        int c;
        return a + b; // c is uninitialized, but its never used, so this code compiles
    }

    // be careful if initialization is within if-statement
//    void doesNotCompile(boolean isOK) {
//        int a;
//        if (isOK) a = 5; // might never be reached
//        // some code using a
//        System.out.println(a);
//    }


    // be careful if initialization is within if-statement
    void doesCompile(boolean isOK) {
        int a;
        if (isOK) {
            a = 5;
        } else {
            a = 2;
        }
        // some code using a
        System.out.println(a);
    }

    // final variables (constants)
    final int MAX_HEIGHT = 100;

    // final can be applied to a reference
    final int[] MY_NUMBER = new int[5];

    void someMethod() {
        // reference cannot be modified, but the content of the object can
        MY_NUMBER[2] = 13; // OK
        // MY_NUMBER=null; // DOES NOT COMPILE
    }

    /*
        - Variable scope
            - variables can go out of scope ("cease to exist")
                1. Local variables: in scope from { to }
                2. Method parameters: in scope for the duration of the method
                3. Instance variables: in scope from declaration until the object is eligible for garbage collector
                4. class variables: in scope from declaration until the program ends

     */


}
