package com.io;

import java.io.*;

public class IODemo {
    /*
        Working with Files

            -  all classes are in java.io.* pkg
            - Java read/ writes in either characters or bytes
            - classes with Stream i their name read/ write binary (usually for images /executable etc)
                - FileInputStream
                - FileOutputStream
                - ObjectInputStream
                - ObjectOutputStream
            - Readers and Writers are used to read/ write text:
                - FileReader
                - BufferedReader
                - FileWriter
                - BufferedWriter
                - PrintWriter
              these are used for text files (data which consists of characters or string)

            Using File Classes
                - using special class File enables one to create File objects
                  from which actual physical files on the hard disk can be created
                - many of the classes mentioned previously can be wrapped, this enables low-level classes
                  to get access to higher-level functionality, which results in efficiency (buffering)

            Abstract Class: InputStream
                - low-level class:
                    FileInputStream: reads one byte at a time
                - high-level class:
                    BufferedInputStream (for efficiency)
                    ObjectInputStream
                - wrapping objects
                    new ObjectInputStream(new FileInputStream("file.dat");


            Abstract Class: OutputStream
                - low-level class:
                    FileOutputStream: reads one byte at a time
                - high-level class:
                    BufferedOutputStream (for efficiency)
                    ObjectOutputStream
                - wrapping objects
                    new ObjectOutputStream(new FileOutputStream("file.dat");

            Abstract Class: Reader
                - low-level class:
                    FileReader:
                - high-level class:
                    BufferedReader (for efficiency)
                    InputStreamReader
                    - a bridge between byte streams and character streams
                - wrapping objects
                    new BufferedReader(new FileReader("in.txt");
                    new BufferedReader(new InputStreamReader("System.in");


            Abstract Class: Writer
                - low-level class:
                    FileWriter:
                - high-level class:
                    BufferedWriter (for efficiency)
                    OutputStreamWriter
                    PrintWriter
                    - a bridge between byte streams and character streams
                - wrapping objects
                    new BufferedWriter(new FileWriter("out.txt");
                    new BufferedWriter(new OutputStreamReader("System.out");

     */

    public static void main(String[] args) {
        File srcFile = new File("X:\\projects\\java_oca_ocp\\input.txt");
        File destFile = new File("X:\\projects\\java_oca_ocp\\output.txt");

        try (var reader = new FileReader(srcFile);
             var writer = new FileWriter(destFile)) {
            int c;
            while ((c = reader.read()) != -1) { // read char
                writer.write(c); // write char
            }
            System.out.println("File successfully moved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // using buffering
        try (var reader = new BufferedReader(new FileReader(srcFile));
             var writer = new BufferedWriter(new FileWriter(destFile))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File successfully moved");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // copying binary file (no buffering)
        File src = new File("X:\\projects\\java_oca_ocp\\src.dat");
        File dest = new File("X:\\projects\\java_oca_ocp\\dest.dat");
        try (var in = new FileInputStream(src);
             var out = new FileOutputStream(dest)) {
            int b;
            while ((b = in.read()) != -1) {
                out.write(b);
            }
            System.out.println("Binary file successfully written");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // copying binary file (with buffering,s ame files)
        try (var in = new BufferedInputStream(new FileInputStream(src));
             var out = new BufferedOutputStream(new FileOutputStream(dest))) {
            var buffer = new byte[1024];
            int numBytesRead;
            while ((numBytesRead = in.read()) > 0) {
                out.write(buffer, 0, numBytesRead);
                out.flush();
            }
            System.out.println("Binary file successfully written");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
