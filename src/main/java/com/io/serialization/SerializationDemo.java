package com.io.serialization;

import java.io.*;

public class SerializationDemo {
    /*
        Serialization & De-serialization
            - serialization is the process of saving in-memory Java object in the
              physical file
            - de-serialization is the opposite: reading from file and creating Java object
            - to make a class serializable:
                - it must implement the marker interface Serializable (marker interface is an interface with no methods)
                - when serializing the object, only instance members are serialized (not static)

            serialVersionUID:
                - a special field in serializable classes which is serialized even though it's static
                    private static final long serialVersionUID = 1L;
                - this field serves as a unique identifier for each class in (de)serialization process
                - during deserialization, the JVM checks if the serialVersionUID of the loaded class is the
                  same as the serialVersionUID of the serialized object
                - if they match, it means that the two versions of the class are compatible
                - if they don't match, the JVM throws an InvalidClassException


            Transient Fields
                - if you don;t want a field to be serialized, you can mark it as transient,
                    e.g. private transient String myPassword;
                - when being deserialized, transient field will revert to it's default Java value
                  (null for String, 0 for int, false for boolean, etc.)
                - if you have instance variables in your serialization class, amke sure that these objects are also
                  marked serializable,
                    e.g. if you want to serialize class Student which has an instance of type Address
                    you have to make Address serializable as well
                - only non-transient instance members will be serialized

            Serialization Tools
                - in order to perform serialization you have to use this class
                    - ObjectOutputStream and ObjectInputStream
                - these classes are high-level classes, and they usually wrap lower-level classes:
                    - FileOutputStream and FileInputStream
                - usually we start with a file stream
                - then we wrap it in a buffered stream to improve performance
                - and then wrap the buffered stream with an object stream to access
                  serialization/ deserialization methods


     */

    static void serialize(Object object, String fileName) throws IOException {
        try (var out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))) {
            out.writeObject(object);
        }
    }

    static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        try (var in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(fileName)))) {
            return in.readObject();
        }
    }

    public static void main(String[] args) {
        User user = new User("John Wayne", "admin");
        try {
            // Serialize user to file
            serialize(user, "user.ser");

            User deserializeUser = (User) deserialize("user.ser");
            // Deserialize user from file

            System.out.println(deserializeUser);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
