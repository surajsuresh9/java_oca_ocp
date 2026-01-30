package com.operators;

public class ArithmeticOperatorsDemo {
    /*
            - Arithmetic Binary Operators
                    - addition a + b
                    - subtraction a - b
                    - multiplication a * b
                    - division a / b
                    - modulo operator a % b

                int a = 11/4;
                    a = 2 (FLOOR value)

                int b = 11%2;
                    b = 3 (reminder of division)

                modulo is ofter used to determine odd and even numbers

                - Rules of numeric promotion
                    - If operands have different data types, Java automatically promotes one of
                      the operands to a larger of 2 data types
                    - If 1 integer, and another decimal, Java promotes int to decimal
                    - byte, short and char are always first promoted to int before the operation is done
                    - The resulting value has the same data type as the promoted operands

                    short a = 17;
                    float b = 15;
                    double c = 35;
                    sout(a*b/c); // a and b are promoted to double, result is double

                    short a = 5;
                    short b = 7;
                    sout(x+y); // x and y promoted to int, res is int

                    short z = x + y; // DOES NOT COMPILE (can't put int into short)

     */
}
