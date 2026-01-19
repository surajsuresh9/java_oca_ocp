package com.collections;

import java.util.*;

public class CollectionsDemo {
    /*
            What is a collection?
                - these interfaces are commonly referred to as Collections
                    - List, Set, Queue(Deque), Map
                - in the end, we want to work with classes
                    - interfaces List, Set and Queue implement Collection
                    - class ArrayList implements List
                    - classes HashSet and TreeSet implement Set
                    - interface Deque extends Queue
                    - class LinkedList implements Queue and List
                    - interface Map doesn't implement Collection
                    - classes HashMap and TreeMap implement Map interface

     */
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        var names1 = new ArrayList<String>();

        // add (): adds element to Collection, return true/ false
        Collection<String> names2 = new ArrayList<>();
        System.out.println(names2.add("John"));// true
        System.out.println(names2.add("John"));// true, allows duplicates

        Collection<String> names3 = new HashSet<>();
        System.out.println(names3.add("John"));// true
        System.out.println(names3.add("John")); // false, no duplicates

        // remove(): removes an element, returns true/ false
        Collection<String> names4 = new ArrayList<>();
        names4.add("John");
        names4.add("George");
        names4.add("John");
        System.out.println(names4);
        System.out.println(names4.remove("John")); // true
        System.out.println(names4); // only first match is removed
        System.out.println(names4.remove("Luke"));// false

        // isEmpty()
        Collection<String> names5 = new ArrayList<>();
        System.out.println(names5.isEmpty());

        // size()
        names5.add("John");
        names5.add("George");
        names5.add("John");
        System.out.println(names5.size());

        //clear(): clears collection
        System.out.println(names5);
        names5.clear();
        System.out.println(names5);

        // contains()
        var names6 = new ArrayList<String>();
        names6.add("John");
        names6.add("George");
        names6.add("John");
        System.out.println(names6.contains("George"));
        System.out.println(names6.contains("Luke"));

        // removeIf()
        Collection<String>names7=new ArrayList<>();
        names7.add("John");
        names7.add("George");
        names7.add("Luke");
        names7.removeIf(s->s.length()>4);
        System.out.println(names7);

        // forEach() // consumer
        names7.forEach(name-> System.out.println(name));

        // equals()
            // comparing type and contents of the Collection
            // implementations vary (ArrayList checks order, HashSet does not)

    }
}
