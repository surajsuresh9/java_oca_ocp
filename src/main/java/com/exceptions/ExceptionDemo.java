package com.exceptions;

import com.class_design.inheriting_methods.D;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {
    /*
            What are exceptions?
                - exceptions occur when something goes wrong during runtime
                    - dividing by 0
                    - fetching non-existent index of array
                    - fetching non-existent index of string
                    -  using null as reference

            Exception Hierarchy
                - java.lang.Throwable
                    - java.lang.Exception
                        - java.lang.RuntimeException (unchecked)
                        - other exceptions (checked)
                    - java.lang.Error (unchecked)

            Checked Exception
                - must be declared or handled by the app code where it is thrown
                - all checked exceptions inherit Exception, but not RuntimeException
                - exception is declared when defining a method
                    - using throws keyword
                - exception is handled using try-catch-resources

            Unchecked Exception

                Exception                                       Error
                ==========================================================================================================================
                ArithmeticException                             thrown when code tries to divide with 0
                ArrayIndexOutOfBoundsException                  thrown when code uses illegal index to access array element
                ClassCastException                              thrown when code tries to cast object to a class which is not an instance
                NullPointerException                            thrown when there is a null reference where object is expected   
                IllegalArgumentException                        thrown by a programmer to indicate w=that teh illegal or inappropriate arg has been passed to a method
                NumberFormatException                           subclass of IllegalArgumentException, thrown when the code tries to convert String to a numeric type, but String doesn't have an appropriate format
                
                
            try-with-resources
                Resource Management
                    - any external data source (files,databases, etc.) are referred to as resources
                    - dealing with resource almost always requires 3 steps:
                        - opening the resource
                        - dealing with the resource (e.g: read/ write)
                        - closing the resource
                    - forgetting to close the resource many cause
                        - resource leak, results in resource becoming unaccessible

     */

    public static void main(String[] args) {
        print4thElement_2();
    }

    // checked exceptions must be handled
    static void readFirstByteFromFile_1(File fileName) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        byte x = (byte) fis.read();
        System.out.println(x);
    }

    static void readFirstByteFromFile_2(File fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            byte x = (byte) fis.read();
            System.out.println(x);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // unchecked exception amy or may not be handled
    static void print4thElement_1() {
        int[] a = {1, 2, 3};
        System.out.println(a[3]);
    }

    // handled unchecked exception
    static void print4thElement_2() {
        int[] a = {1, 2, 3};
        try {
            System.out.println(a[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Index 3 is out of bounds");
        }
    }
}

// manually throw an exception

class Student {
    private int id;
    private String fullName;

    Student(int id, String fullName) {
        if (id < 10 || fullName.length() > 100) {
            throw new IllegalArgumentException("Illegal arguments!");
        }
        this.id = id;
        this.fullName = fullName;
    }

    public static void main(String[] args) {
        Student s = new Student(1, "John Wayne"); // IllegalArgumentException is thrown
    }
}


// main method must also declare or handle the checked exception
class OutOfMilkException extends Exception {
}

class MyExceptionDemo {
    static void getMilk() throws OutOfMilkException {
        System.out.println("Getting the milk..");
    }

    public static void main(String[] args) throws OutOfMilkException {
        getMilk();
    }
}

// catching multiple exceptions
class MultipleException {
    void readFirstByteFromFile(File fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            byte x = (byte) fis.read();
            System.out.println(x);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // alternate syntax
    void readFirstByteFromFile2(File fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            byte x = (byte) fis.read();
            System.out.println(x);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }

    // finally block
    void readFirstByteFromFile3(File fileName) {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            byte x = (byte) fis.read();
            System.out.println(x);
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Running readFirstByteFromFile3... ");
        }
    }
}

class TryWithResourceDemo {

    // method opens, reads and closes file
    void readFile(String fileName) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File(fileName));
            // read the file
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // try-with-resources
    // resource is closed automatically
    void readFile2(String fileName) {
        try (FileInputStream fis = new FileInputStream(new File(fileName))) {
            // read the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// custom resource
class MyFileClass implements AutoCloseable {

    private final int num;

    public MyFileClass(int num) {
        this.num = num;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing MyFileClass # " + num);
    }
}

class MyFileClassDemo {
    public static void main(String[] args) {
        try (
                MyFileClass bookReader = new MyFileClass(1);
                MyFileClass movieReader = new MyFileClass(2);
        ) {
            System.out.println("try-block");
            throw new RuntimeException();
        } catch (Exception e) {
            throw new RuntimeException("catch block");
        } finally {
            System.out.println("finally block");
        }
    }
}

// when exception occurs, all the resources are closed, starting with the latest
// and only then the program continues to be executed in a regular order




/* Suppressed Exceptions
    - suppose close() can throw an exception, e.g.

        public void close() throw IllegaArgumentException{
            throw new IllegaArgumentException("this door doesn't close");
        }

    - if try-with-resources block also throws an exception in catch block then
        - only the 1st exception will be caught
        - other exceptions will be suppressed
 */

class Door implements AutoCloseable {

    @Override
    public void close() throws IllegalArgumentException {
        throw new IllegalArgumentException("this door doesn't close"); // 2nd exception => suppressed
    }

    public static void main(String[] args) {
        try (Door d = new Door()) {
            throw new IllegalStateException("Something is wrong");
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage()); // 1st exception => caught
            for (Throwable t : e.getSuppressed()) {
                System.out.println("Suppressed: " + t.getMessage()); // print suppressed exceptions

            }
        }
    }
}