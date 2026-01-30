package com.building_blocks;

public class DataTypesDemo {
    /*
            - Primitive Types

            keyword          type                       min              max             default          example
            ======================================================================================================
            boolean          true/false                 -                -               false            true
            byte             8 bit integral val         -128             127              0               118
            short            16 bit integral val        -32,768          32767            0               -202
            integer          32 bit integral val        -2,147,483,648   2,147,483,647    0               5106
            long             64 bit integral val        -2^63            2^63-1           0L              1234L
            float            32 bit floating val        -                -                0.0f            511.432f
            double           64 bit floating val        -                -                0.0             511.432
            char             16 bit Unicode val         0                65,535           \u0000          'c'

            - Notes
                - in Java, boolean true and false are completely unrelated to 1 and 0
                - all numeric types are signed (allow negative numbers)
                - float requires F (or f) at the end
                    float x = 2.7 // DOES NOT COMPILE
                    float x = 2.7f // OK
                    float x = 2.7F // OK
                - long requires l (or and preferably L) at the end
                    long a = 1234567891234; // DOES NOT COMPILE
                    long a = 1234567891234L; // OK
                    long a = 1234567891234l; // OK
                - bit size of boolean is not specific (depends on VM)

            - Supported decimal formats
                - base 10 (digits 0-9), "normal" numbers
                - octal (digit 0-7), uses a prefix (e.g. 017)
                - hexadecimal (digits 0-9, and letters A-F/ a-f), uses 0x or 0X as a prefix
                    - format is case insensitive (e.g. 0xFF, 0XFF, 0Xff, 0xff, etc.)
                - binary (digits 0 and 1), uses 0b or 0B as prefix (e.g. 0b10, 0B11, etc.)

            - for readability, the underscores (_) is allowed
              but NOT in the beginning, at the end, right before or after a decimal point

              int a = 1_000_000; // normal usage
              int b = 1_2; // OK, but not very useful
              int c = 1_____2; // OK, but even less useful
              double d = 1_000_000.000_001; // OK and makes sense

              double x = _10.1; // NOT OK
              double y = 10.1_; // NOT OK
              double z = 10_.1; // NOT OK
              double w = 10._1; // NOT OK

            - Wrapper Classes
                - primitives are not objects, and sometimes we prefer to work with objects
                - each primitive has a wrapper class
                    - an object type which corresponds to the primitive
                - most common way to create an object from the primtive
                    - use static method valueOf():
                        Integer a = Integer.valueOf(5)

            Primitive Type              Wrapper Class               Example
            =============================================================================================
            boolean                     Boolean                     Boolean.valueOf(true);
            byte                        Byte                        Byte.value((byte)12);
            short                       Short                       Short.valueOf((short)12);
            int                         Integer                     Integer.valueOf(12);
            long                        Long                        Long.valueOf(12L);
            float                       Float                       Float.valueOf(12f);
            double                      Double                      Double.value(12.0);
            char                        Character                   Character.valueOf('c');

            - Strings
                - Strings are NOT primitive data types, but they're used like primitives
                    String greeting = "Hello";

     */

    public static void main(String[] args) {
        // valueOf() can be used to convert String into Wrapper class
        Integer n = Integer.valueOf("12");

        // wrapper classes come with some useful methods, e.g.
        int m = Integer.parseInt("101");

        // been deprecated since Java 9
        // Integer i = new Integer(5);

        // wrapper classes offer many useful helper methods
        // byteValue(), charValue(), intValue(), shortValue(), floatValue(),
        // doubleValue(), booleanValue()
        Double d = Double.valueOf(314.67);
        System.out.println(d.byteValue());
        System.out.println(d.intValue());
        System.out.println(d.doubleValue());

    }
}
