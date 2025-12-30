package com.strings.stringbuilder;

public class StringBuilderDemo {

    /*
    StringBuilder

    - StringBuilder is a mutable class which contains a String
    - has many useful methods for manipulating strings
    - some methods work in identical way as with a normal String
        substring(), indexOf(), length(), charAt()
   */

    public static void main(String[] args) {
        StringBuilder name = new StringBuilder("John");
        name.append("Wayne");
        System.out.println(name);

        name.append(1).append(true); // all args are converted to String
        System.out.println(name);

        // insert()
        name = new StringBuilder("John Wayne");
        name.insert(5, "D. ");
        System.out.println(name);
        name = new StringBuilder("John Wayne");
        name.insert(5, "D. ").insert(6, "A");
        System.out.println(name);

        // delete()
        StringBuilder sb1 = new StringBuilder("abcdef");
        System.out.println(sb1.delete(1, 4)); // deletes from 1 to 4 (excluded)

        // deleteCharAt()
        StringBuilder sb2 = new StringBuilder("abcdef");
        System.out.println(sb2.deleteCharAt(2));
//        System.out.println(sb2.deleteCharAt(6)); // StringIndexOutOfBoundsException

        // replace()
        StringBuilder sb = new StringBuilder("abcdef");
        sb.replace(1, 3, "JOHN"); // removes chars from 1 to 3 (excluded) and inserts nre string, 'b' and 'c' are removed and "JOHN" is inserted
        System.out.println(sb);
        // if final index is too large, replace goes through the end (no exception!)
        name = new StringBuilder("John Wayne");
        name.replace(5, 100, "Doe");
        System.out.println(name);

        // reverse()
        sb = new StringBuilder("LUKA");
        sb.reverse();
        System.out.println(sb);

        // toString()
        sb = new StringBuilder("John Wayne");
        String str = sb.toString();

        // SB doesn't implement equals() method i.e equals() is same as ==
        StringBuilder name1 = new StringBuilder("John Wayne");
        StringBuilder name2 = new StringBuilder("John Wayne");
        System.out.println("name1.equals(name2): " + name1.equals(name2));
        System.out.println("name1 == name2: " + (name1 == name2));

        // if you want to compare content, convert to String and then compare
        System.out.println("name1.toString().equals(name2.toString(): " + name1.toString().equals(name2.toString()));

        // substring() returns a String and doesn't change the StringBuilder
        name = new StringBuilder("John Wayne");
        name.substring(2, 6);
        System.out.println(name);
        String subName = name.substring(2, 6);
        System.out.println(subName);


    }
}
