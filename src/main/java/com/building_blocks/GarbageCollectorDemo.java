package com.building_blocks;

public class GarbageCollectorDemo {
    /*
          - What is Garbage Collector?
            - all Java objects are stored in program's heap memory
            - garbage collection is a process of automatically freeing memory on the heap
                - by removing objects which are no longer reachable in the program
            - these objects are said to be eligible for garbage collection
            - once the object is eligible for gc Java can remove it from the heap (nad free memory)
            - this process is out of the programmers control
                -   you can't know if and when memory will be freed

          - System.gc()
            - with this method you can suggest Java to clean the heap
                System.gc();
            - but it's not guaranteed to do anything

          - Eligibility for Garbage Collection
            - Object is eligible for GC once it is no longer reachable by the program
                - the object has no reference pointing to it
                - all references of the object have gone out of scope
                - in other words, when the object 'hangs in the air'

     */

    public static void main(String[] args) {
        String a, b;
        a = new String("Emperor");
        b = new String("King");
        a = b;
        String c = a;
        a = null;
    }

    // Emperor is eligible for GC
    // objects, not references are collected by the gc
}
