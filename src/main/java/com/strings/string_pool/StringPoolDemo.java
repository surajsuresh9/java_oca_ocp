package com.strings.string_pool;

public class StringPoolDemo {
    /*
        - Lets say you create a new string literal with value "John"   [String name="John"]
            - JVM stores this in the memory location known as String Pool or Intern Pool
         - Now you create a new String variable and assign it the same literal value ("John")   [String newName=new String("John")]
            - instead of creating a new memory spot for this literal value
            - Jva will save the memory and look in the String pool
            - new variable will point to the existing location in the String pool
     */
    public static void main(String[] args) {

        String name = "John";
        String theName = "John";
        String newName = new String("John");
        String newName2 = new String("John").intern();
        System.out.println(name == theName); // true
        System.out.println(name == newName); // false
        System.out.println(name == newName2); // true

        String s1 = "John";
        String s2 = "  John  ".trim();
        System.out.println(s1 == s2); // false; pool is compile-time, and trim() is evaluated at run time

        String s3 = "John Wayne";
        String s4 = "John" + " " + "Wayne";
        System.out.println(s3 == s4); // true; concatenation is done at the compile-time
        // compiler now knows that these are the same literals

        // you can instruct compiler to sue the pool even with runtime methods
        s1 = "John";
        s2 = "  John  ".trim().intern(); // executed at compile time
        System.out.println(s1 == s2); // true;
        s1 = "John";

        s2 = "  John  ".trim();
        System.out.println(s1 == s2.intern()); // true;
    }


}
