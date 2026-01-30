package com.operators;

public class AssignmentOperatorsDemo {
    /*
            - Assignment operator
                    - assignment operator (=) has the lowest precedence
                        a = b + c
                    - first the operation on teh right-hand side is performed
                    - the result is assigned to a variable on the left-hand side

                // auto-casting: Java automatically promotes smaller to larger data type
                    short x = 5;
                    int y;
                    y = x; // OK (x is cast to int)

                    int a = 5;
                    short b;
                    b = a; // (NOT OK! you can't put int in short)
                    // solution: explicit casting b = (short) a; // OK

                    int x = 1.0; // NOT OK
                    int y = 123L; // NOT OK
                    long z = 5; // OK
                    long w = (byte)7; // OK
                    float k = 2.3; // NOT OK
                    float l = 2.3F; // OK
                    double m = 2.3f; //OK
                    double m = 3.14; //OK
                    float pi = n; // NOT OK
                    short a = 7; // OK
                    short b = 5; // OK
                    short c = (short) (a + b) // OK

                // compound assign operators
                    a += 5; // a = a + 5
                    a -= 5; // a = a - 5
                    a *= 5; // a = a * 5
                    a /= 5; // a = a / 5

                - Return value of assignment operator
                    - expression a = 2 does two things
                        1. assigns value 2 to variable a
                        2. returns value 2
                    - int x = 5;
                      int y = (x = 3) * 2; // y = 6, x = 3;


                    boolean isOK = false;
                    if(isOK = true) { // return true
                        sout("A"); // A
                    } else {
                        sout("B");
                    }

                    boolean isOK = false;
                    if(isOK == true) { // return false
                        sout("A");
                    } else {
                        sout("B"); // B
                    }

     */
}
