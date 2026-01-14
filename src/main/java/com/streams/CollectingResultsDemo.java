package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResultsDemo {
    /*
            Collecting Results
                - predefined collectors
                    - there are static methods in the Collectors class

            Common grouping/ partitioning collectors

            Collector                                                  Description                                                  Return value(w/ collect)
            =================================================================================================================================================
            averagingDouble(ToDoubleFunction f)                        Calculates average for doubles                               Double
            averagingInt(ToIntFunction f)                              Calculates average for integers                              Double
            averagingLong(ToLongFunction f)                            Calculates average for longs                                 Double
            counting()                                                 Counts number of elements                                    Long
            filtering(Predicate p, Collector c)                        Applies filter before calling downstream collector           R


            groupingBy(Function f)                                     Creates map                                                  Map<K,List<T>>
            groupingBy(Function f,Collector dc)                        Creates map where downstream collector is                    Map<K,List<T>>
            groupingBy(Function f,Supplier s, Collector dc             Creates map where both map supplier and downstream           Map<K,List<T>>
                                                                       collector are provided
            joining(CharSequence cs)                                   Creates string using cs as delimiter                         String


            minBy(Comparator c)                                        Finds smallest elements                                      Optional<T>
            maxBy(Comparator c)                                        Finds smallest elements                                      Optional<T>
            mapping(Function f, Collector dc)                          Adds another level of collectors                             Collector
            partitioningBy(Predicate p)                                Creates map grouping                                         Map<Boolean, List<T>>
            partitioningBy(Predicate p, Collector c)                   Creates map grouping                                         Map<Boolean, List<T>>


            summarizingDouble(ToDoubleFunction f)                      Calculates summarizing stats                                 DoubleSummaryStatistics
            summarizingInt(ToIntFunction f)                            Calculates summarizing stats                                 IntSummaryStatistics
            summarizingLong(ToLongFunction f)                          Calculates summarizing stats                                 LongSummaryStatistics
            summingDouble(ToDoubleFunction f)                          Calculates sum for doubles                                   Double
            summingInt(ToIntFunction f)                                Calculates sum for integers                                  Integer
            summingLong(ToLongFunction f)                              Calculates sum for longs                                     Long


            teeing(Collector c1, Collector c2, BiFunction f)           Takes the results of two collectors                          R
                                                                       to create a new type
            toList()                                                   Creates arbitrary type of list                               List
            toSet()                                                    Creates arbitrary type of set                                Set
            toCollection(Supplier s)                                   Creates Collection of specified type                         Collection


            toMap(Function k, Function v)                              Creates map using functions to map keys and values           Map
            toMap(Function k, Function v, BinaryOperator m)            Creates map using functions to map keys and                  Map
                                                                       values with merge rule
            toMap(Function k, Function v, BinaryOperator m,            Creates map using functions to map keys and values           Map
            Supplier s)                                                with merge rule and map type supplier

     */

    record MyData(int sum, double average) {
    }

    public static void main(String[] args) {
        // joining() example
        var names = Stream.of("John", "George", "Luke");
        String joinedNames = names.collect(Collectors.joining("-"));
        System.out.println(joinedNames);

        // averaging() example
        names = Stream.of("John", "George", "Luke");
        Double avgNameLength = names.collect(Collectors.averagingInt(String::length));
        System.out.println(avgNameLength);

        // toCollection() example
        names = Stream.of("John", "George", "Luke", "Joe");
        TreeSet<String> sortedName = names.filter(s -> s.startsWith("J"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(sortedName);

        // toMap() example
        names = Stream.of("John", "George", "Luke");
        Map<String, Integer> collectedMap = names.collect(Collectors.toMap(s -> s, String::length));// k,v
        System.out.println(collectedMap);
        names = Stream.of("John", "George", "Luke");
//        Map<Integer, String> collectedMap2 = names.collect(Collectors.toMap(String::length, s -> s));// k,v , throws IllegalStateException, duplicate key, need to provide merge rule
        Map<Integer, String> result = names
                .collect(Collectors.toMap(String::length, s -> s, (s1, s2) -> s1 + " : " + s2));
        System.out.println(result);

        // if we don't mention the class, toMap() can return any class which implements
        // Map interface (usually HashMap, but not guaranteed)
        names = Stream.of("John", "George", "Luke");
        TreeMap<Integer, String> result2 = names.collect(
                Collectors.toMap(String::length,
                        s -> s, (s1, s2) -> s1 + " : " + s2,
                        TreeMap::new));
        System.out.println(result2);

        // groupingBy() example1
        names = Stream.of("John", "George", "Luke");
        Map<Integer, List<String>> collected = names.collect(Collectors.groupingBy(String::length));
        System.out.println(collected);

        // groupingBy() example2 (using downstream collector)
        names = Stream.of("John", "George", "Luke");
        Map<Integer, Set<String>> integerSetMap = names
                .collect(Collectors
                        .groupingBy(String::length,
                                Collectors.toSet()));// downstream collector ensures value will be Set
        System.out.println(integerSetMap);

        // groupingBy() example3 (using map supplier and downstream collector)
        names = Stream.of("John", "George", "Luke");
        TreeMap<Integer, Set<String>> treeMap = names
                .collect(Collectors
                        .groupingBy(String::length,
                                TreeMap::new, // map supplier ensures that the Map implementation will be TreeMap
                                Collectors.toSet())); // downstream collector ensures that the value will be Set
        System.out.println(treeMap);

        // partitioningBy() only has 2 groups: true and false
        names = Stream.of("John", "George", "Luke");
        Map<Boolean, List<String>> res = names.collect(Collectors.partitioningBy(s -> s.length() <= 4));
        System.out.println(res);

        // partitioningBy() with Set instead of List
        names = Stream.of("John", "George", "Luke");
        Map<Boolean, Set<String>> res2 = names.collect(Collectors.partitioningBy(s -> s.length() <= 4, Collectors.toSet()));
        System.out.println(res2);


        // teeing is used to return multiple values e.g. sum and average
        // Step1: create a new type which stores values: record MyData
        // Step2: use stream to return the result of the type MyData
        Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);
        MyData res3 = numbers.collect(Collectors.teeing(
                Collectors.summingInt(i -> i), // first collector
                Collectors.averagingDouble(i -> i),// second collector
                MyData::new // merging function
        ));
        System.out.println("Sum: " + res3.sum());
        System.out.println("Avg: " + res3.average());
    }
}
