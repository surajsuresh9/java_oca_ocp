package com.streams;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalStreamDemo {
    /*

            Terminal Stream Operations

            Method          When applied on infinite stream         Return value            Reduction(all the contents of the stream are combined into a single primitive or object)
            ============================================================================================================
            count()         does not terminate                      long                     yes
            min()           does not terminate                      Optional<T>              yes
            max()           does not terminate                      Optional<T>              yes
            findAny()       terminates                              Optional<T>              no
            findFirst()     terminates                              Optional<T>              no
            allMatch()      sometimes terminates                    boolean                  no
            anyMatch()      sometimes terminates                    boolean                  no
            noneMatch()     sometimes terminates                    boolean                  no
            forEach()       does not terminate                      void                     no
            reduce()        does not terminate                      varies                   yes
            collect()       does not terminate                      varies                   yes

     */

    public static void main(String[] args) {
        // count
        Stream<String> names = Stream.of("John", "George", "Ben");
        System.out.println(names.count());

        // for infinite streams, count never terminates

        // find min, max
        names = Stream.of("John", "George", "Ben");
        Optional<String> min = names.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);

        // suing with emoty stream
        Optional<?> minEmpty = Stream.empty().min((s1, s2) -> 0);
        System.out.println(minEmpty.isPresent());

        // these methods hang if applied to infinite streams

        // find a value
        names = Stream.of("John", "George", "Ben");
        Stream<String> inf = Stream.generate(() -> "Luke");
        names.findAny().ifPresent(System.out::println); // names.findAny() returns Optional
        inf.findAny().ifPresent(System.out::println); // terminates infinite stream

        // findFirst() will always return the first element

        // matching
        var myList = List.of("George", "21", "Ben");
        inf = Stream.generate(() -> "Luke");
        Predicate<String> p = s -> Character.isLetter(s.charAt(0));

        System.out.println(myList.stream().anyMatch(p));
        System.out.println(myList.stream().allMatch(p));
        System.out.println(myList.stream().noneMatch(p));
        System.out.println(inf.anyMatch(p));
        // matching methods terminate infinite streams

        // iterating
        Stream<String> names2 = Stream.of("John", "George", "Ben");
        names2.forEach(System.out::print);
        System.out.println();

        // reduction
        // usually starts with an initial value and merge to next value
        var myArr = new String[]{"L", "u", "k", "e"};
        String reducedString = Arrays.stream(myArr).reduce("", (a, b) -> a + b); // identity -> initial value, a-> currVal, b-> nextVal
        System.out.println(reducedString);

        // method reference
        Stream<String> cStream = Stream.of("L", "u", "k", "e");
        reducedString = cStream.reduce("", String::concat);
        System.out.println(reducedString);

        Stream<Integer> iStream = Stream.of(13, 7, 10);
        System.out.println(iStream.reduce(1, (a, b) -> a * b));

        // if identity is omitted, Optional is returned
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> empty = Stream.empty();
        Stream<Integer> oneElement = Stream.of(7);
        Stream<Integer> threeElement = Stream.of(3, 7, 10);
        empty.reduce(op).ifPresent(System.out::println);
        oneElement.reduce(op).ifPresent(System.out::println);
        threeElement.reduce(op).ifPresent(System.out::println);

        // when dealing with different types
        Stream<String> names3 = Stream.of("John", "George", "Ben");
        int len = names3.reduce(0, (i, s) -> i + s.length(), (a, b) -> a + b);
        // initializer -> initializes the value
        // accumulator -> performs operations
        // combiner -> combines prev values to curr val
        System.out.println(len);

        // collecting (mutable reduction)
        cStream = Stream.of("L", "u", "k", "e");
        StringBuilder myName = cStream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        // StringBuilder::new -> supplier, creates the object that will store the results as we collect data
        // StringBuilder::append -> accumulator, passed as BiConsumer
        // StringBuilder::append -> combiner, passed as BiConsumer
        System.out.println(myName);
        // if parallel stream was used, the order would be unpredicatable

        // keeping the order in collection (sorted)
        cStream = Stream.of("L", "u", "k", "e");
        TreeSet<Object> mySet = cStream.collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        // TreeSet::new -> supplier, creates an empty TreeSet
        // TreeSet::add -> accumulator, adds a single String from Stream to TreeSet
        // TreeSet::addAll -> combiner, adds all elements of one TreeSet ti another
        System.out.println(mySet); // L,e,k,u

        // using Collectors class
        cStream = Stream.of("L", "u", "k", "e");
        mySet = mySet.stream().collect(Collectors.toCollection(TreeSet::new));
        System.out.println(mySet);

        Set<String> set = cStream.collect(Collectors.toSet());// you don;t know which implementation of Set you get (most likely HasSet)
        System.out.println(set); // order is unpredictable
    }


}
