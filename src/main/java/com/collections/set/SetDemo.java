package com.collections.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
    /*
            - Set Interface
                - doesn't allow duplicate entries
                - implementations
                     - HashSet
                     - TreeSet
                - HashSet stores (key, value) elements in hash table
                    - key is hashCode(), value is Object
                    - doesn't keep the order
                    - adding each element takes the same time
                - TreeSet stores elements in a sorted tree structure
                    - keeps the order
                    - adding each element takes more time as tree grows bigger

     */

    public static void main(String[] args) {
        Set<String> names = new HashSet<>();
        System.out.println(names.add("John"));
        System.out.println(names.add("George"));
        System.out.println(names.add("John"));
        System.out.println(names.add("Ben"));
        System.out.println(names);
        names.clear();

        System.out.println("==============");
        names = new TreeSet<>();
        System.out.println(names.add("John"));
        System.out.println(names.add("George"));
        System.out.println(names.add("John"));
        System.out.println(names.add("Ben"));
        System.out.println(names);
    }
}
