package com.operators;

public class ComparisonOperatorsDemo {
    /*
            - Comparison operators
                - return a boolean value (true or false)
                - equals operator(a == b)
                    - primitives: returns true if values are the same
                    - objects: returns true if both values reference to the same object
                - not equals operator(a != b) works in the same way
                    - primitives: returns false if values are the same
                    - objects: returns false if both values reference to the same object
                - you can only compare values of similar type (auto-casting applies)

            - Relational Operators (<, >, <=, >=)

            - Logical Operators (&, |, ^)

            - Conditional Operators (&&, ||)

            - Ternary operator
                e.g-1: (a = 5, b = 10, c = 15)
                int d = (a < b) ? 7 : c++;
                sout(c + " " + d);// 7 15

                e.g-2:
                int d = (a > b) ? ++c : 12;
                sout(c + " " + d);// 12 15






     */
    public static void main(String[] args) {
        String name1 = new String("John Wayne");
        String name2 = new String("John Wayne");
        String name3 = name1;
        System.out.println(name1 == name2); // point to different objects
        System.out.println(name1 == name3); // point to same objects
    }
}
