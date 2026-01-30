package com.building_blocks;

import java.util.Random;

public class BuildingBlocksDemo {
    /*
            - Major components of Java

                - Java Development Kit (JDK)
                    - to do Java development one needs JDK (Java Development Kit)
                    - Oracle's JDK, OpenJDK, etc. - select version 1.8 or 17
                    - key commands provided by JDK
                        - javac: converts .java source files into .class bytecode
                        - java: executes a program
                        - jar: java archive (packaging files together)
                        - javadoc: for documentation

                - Java Runtime Environment (JRE)
                    - In Java 8 abd earlier, this was a subset of JDK
                    - JRE allows user to run Java applications (no complier)
                    - after Java 8, one just uses JDK to run Java applications

                - Class Structure
                    - classes are building blocks of every Java program
                    - to design a class means to describe parts and characteristics of these blocks
                    - in order to use a class you need to create an object (most of the time)
                        - you can think of a class as a blueprint, object as realization
                    - an object is a single representation of the class, also called instance of a class
                    - a reference is a variable that points to an object

                - Fields and Methods
                    - two main elements (members) of Java classes are fields and methods
                    - fields are sometimes called variables
                        - to be precise: all fields are variables, but not all variables are fields
                    - fields hold the information about the state of an object or a class
                    - methods describe some action or operation on that state
                        - methods are similar to functions in some older programming languages

                - Comments
                    - comments are used to make code more readable
                        - they are ignored by the compiler
                    - they are three ways to comment out text
                        - comment until the end of the line: //
                        - comment everything within /* and
                        // */
        /*
                        - comment starting with /** (Javadoc)

                - Classes and source files
                    - it's a good practice to have each class in its own .java file
                    - its possible to have more classes in one file
                        - but only one of them is top-level class
                    - top-level class is almost always marked as public, but it's not necessary
                    - if you mark the top-level class with public, then the filename must match the class name
                    - only one class in the file can eb marked as public

                - the main() method
                    - Java program starts by executing the main() method:
                        - public static void main(String[]args)

                    - other permissible ways to write main()
                        - public static void main(String[] args){}
                        - public static void main(String[] anyName){}
                        - public static void main(String args[]){}
                        - public static void main(String... args){}
                        - public final static void main(String[] args){}
                        - static public void main(String[] args){}

                        Note: return type must follow the name of the method

                 - Packages
                    - Java classes are stored in different packages
                    - you can think of them as folders in which the classes are present
                    - in order to use a class, you must import a package in your pragram
                    - name of the package usually looks something like
                        - com.udemy.javacourse.ocp
                    - this means that there is a folder 'com', in which there is a subfolder 'udemy', with subfolder
                      'javacourse', with subfolder 'ocp' containing classes
                    - package declaration must be first line
                    - all imports must be followed after the package

                - Compile, Run adn Archive Java Files
                    - javac {A.java} -> .class file is generated
                    - java {A.java} -> executes the Java program

         */
         /*
                - Objects
                    - object is an instance of the class (house -> blueprint)
                    - new object is created using keyword new:
                        Student s = new Student();
                    - when object is created, the constructor of the object is called
                    - if no constructor is provided, compiler will generate the default constructor

                - Order of initialization
                    - instance initializer - code block outside the method
                    - order of initialization
                        - fields and instance initializer blocks in order in which they appear
                        - constructor runs in the end

         */

    public static void main(String[] args) {
        System.out.println("First Name: " + args[0]);
        System.out.println("Last Name: " + args[1]);
    }
}


class NumberGenerator {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextInt(100));
    }
}


class Employee {

    public Employee() {
        System.out.println("Employee is created");
    }

    public void Employee() { // this code will compile, this is a method, not a constructor
        System.out.println("Employee is created");
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.Employee();
    }
}

class Dog {
    private String name = "Chip";

    public Dog() {
        name = "Teddy";
        System.out.println("Inside the constructor...");
    }

    {
        System.out.println("Inside the initializer block");
    }

    public static void main(String[] args) {
        Dog d = new Dog();
        System.out.println(d.name);
    }
}