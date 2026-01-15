package com.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SpliteratorDemo {

    /*

            Spliterator
                - A Spliterator (splittable iterator) is a Java interface that acts as the foundation for the Stream API.
                  It is designed for efficiently traversing and partitioning elements of a data source,
                  primarily to enable parallel processing.

                How Spliterator works
                - you start with some kind of collection with n elements
                    - imagine a box containing number of toys
                - now you want to split the collection in two (or more collections)
                    - imagine moving some toys from the original box to the new box
                - inorder to do this uou have to create an object call Spliterator
                - once you have Spliterator object, you can apply some common methods

                Common Spliterator Methods

                Method                                      What it does
                ========================================================================================================
                Spliterator<T> trySplit()                   Returns Spliterator containing about half of the data, which
                                                            is then removed from the original Spliterator
                                                            (if data is no longer splittable it returns null)

                void forEachRemaining(Consumer<T> c)        Processes remaining elements in Spliterator

                boolean tryAdvance(Consumer<T> c)           Process single element from Spliterator(if exists),
                                                            returns if the elements is processed
     */

    public static void main(String[] args) {
        List<String> list = Arrays.asList("One", "Two", "Three", "Four", "Five");
        Stream<String> stream = list.stream();
        Spliterator<String> originalSpliterator = stream.spliterator();
        Spliterator<String> newSpliterator = originalSpliterator.trySplit();
        newSpliterator.forEachRemaining(System.out::println);
        System.out.println("------------");
        originalSpliterator.forEachRemaining(System.out::println);

        /*
            Note:
             Once you apply forEachRemaining() method on a Spliterator, all elements
             are processed and Spliterator is now empty, so if you run this command again
             originalSpliterator.forEachRemaining(System.out::println); // it will return nothing
         */

        System.out.println("=======================================");
        List<String> list1 = Arrays.asList("One", "Two", "Three", "Four", "Five");
        Stream<String> stream1 = list.stream();
        Spliterator<String> originalSpliterator1 = stream1.spliterator();
        Spliterator<String> newSpliterator1 = originalSpliterator1.trySplit();
        newSpliterator1.tryAdvance(System.out::println);
        System.out.println("-------------");
        newSpliterator1.forEachRemaining(System.out::println);
        System.out.println("-------------");
        originalSpliterator1.tryAdvance(System.out::println);
        System.out.println("-------------");
        originalSpliterator1.forEachRemaining(System.out::println);

    }


}
