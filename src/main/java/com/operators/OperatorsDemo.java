package com.operators;

public class OperatorsDemo {
    /*
            - Operators
                - Three kinds of operators in Java
                    - Unary operator:
                        a++;
                    - Binary operator:
                        a = b + c;
                    - Ternary operator:
                        a = (b > 0) ? 3 : 2;

     */

    public static void main(String[] args) {
        int a = 2 + 2 * 2 + 10 / 5 + 1;// 2 + (2 * 2) + 2 +1
        System.out.println(a); // 9

        boolean b = 2 > 1 && 2 + 2 * 2 == 5; // 2 > 1 && (2 + (2 * 2)) == 5
        System.out.println(b);// false

        int x = 1;
        int y = ++x * 2; // 2*2
        System.out.println(x + " " + y); // 2 4


        /*
                - Unary Operator
                    - Unary = requires only 1 operand

                    Operator                                Example
                    ====================================================
                    Logical complement                      !b
                    Bitwise complement                      ~a
                    Plus                                    +a
                    Negation(minus)                         -a
                    Increment                               ++a, a++
                    Decrement                               --a, a--
                    Cast                                    (int) a

                - Increment and Decrement operators
                    - a++: increases value by 1 and returns the NEW value
                    - ++a: increases value by 1 and returns the OLD value
                    - --a: decreases value by 1 and returns the NEW value
                    - a--: decreases value by 1 and returns the OLD value
         */
        a = 5;
        int b1 = a++;
        System.out.println(a); //6
        System.out.println(b1);  //5

        a = 5;
        b1 = ++a;
        System.out.println(a); //6
        System.out.println(b1);  //6

        a = 5;
        a = a++;
        System.out.println(a);
    }
}
