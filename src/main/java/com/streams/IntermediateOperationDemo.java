package com.streams;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperationDemo {
    /*
            Intermediate Operations
                - produces a stream as a result
                - can deal with infinite streams (by returning another infinite stream)
                - cna be omitted in a pipeline (unlike source and terminal operations)
     */

    public static void main(String[] args) {
        // filtering
        Stream<String> names = Stream.of("John", "George", "Ben");
        names.filter(n -> n.startsWith("G")).forEach(System.out::println);

        // remove duplicates
        names = Stream.of("John", "George", "Ben");
        names.distinct().forEach(System.out::println);

        // restricting by position
        Stream<Integer> nums = Stream.iterate(1, n -> n + 1); // infinite stream starting from one
        nums
                .skip(3) // create stream by skipping first 3 elements from source stream
                .limit(4)
                .forEach(System.out::println);

        // mapping using map()
        names = Stream.of("John", "George", "Ben");
        names.map(n -> n.length()).forEach(System.out::println);

        // mapping using flatMap()
        List<String> zero = List.of();
        List<String> one = List.of("John");
        List<String> two = List.of("George", "Ben");
        List<List<String>> names2 = List.of(zero, one, two);
        names2.stream()
                .flatMap(m -> m.stream()) // argument to flatMap() is Function
                .forEach(System.out::println);
        // removes the empty list, and changes all elements to be at the top of the stream

        // sorting
        names = Stream.of("John", "George", "Benedict");
        names.sorted().forEach(System.out::println); // natural sorting

        // we can provide Comparator for custom sorting
        names = Stream.of("John", "George", "Benedict");
        names.sorted(Comparator.comparingInt(String::length))
                .forEach(System.out::print);

        // peek()
        names = Stream.of("John", "George", "Benedict");
        long count = names.peek(n -> n.startsWith("G")).count();
        System.out.println(count);

        // if we want to see what is going on in the pipeline
        names = Stream.of("John", "George", "Benedict");
        count = names.filter(n -> n.startsWith("G"))
                .peek(System.out::println).count(); // argument of peek is Consumer
        System.out.println(count);
    }
}
