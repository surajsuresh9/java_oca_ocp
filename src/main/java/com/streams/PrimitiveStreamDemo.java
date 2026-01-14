package com.streams;

import java.util.*;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PrimitiveStreamDemo {
    /*
            Primitive Streams
                - when working with primitive values, it's more convenient to sue primitive streams
                - there are 3 types of primitive streams
                    - IntStream - used for int, byte, short, char
                    - LongStream - used for long
                    - DoubleStream - used for double and float
                - primitive streams have some unique methods

                Method                                  Primitive stream                                        What it does
                =====================================================================================================================================
                OptionalDouble average()                IntStream, LongStream, DoubleStream                     Arithmetic mean of elements
                Stream<T> boxed()                       IntStream, LongStream, DoubleStream                     Stream<T> where T is wrapper class associated with primitve value
                OptionalInt max()                       IntStream                                               Max element of stream
                OptionalLong max()                      LongStream                                              Max element of stream
                OptionalDouble max()                    DoubleStream                                            Max element of stream
                OptionalInt min()                       IntStream                                               Min element of stream
                OptionalLong min()                      LongStream                                              Min element of stream
                OptionalDouble min()                    DoubleStream                                            Min element of stream
                IntStream range(int a, int b)           IntStream                                               Returns IntStream from a(incl) to b(excl)
                LongStream range(long a, long b)        LongStream                                              Returns LongStream from a(incl) to b(excl)
                IntStream rangeClosed(int a, int b)     IntStream                                               Returns IntStream from a(incl) to b(incl)
                LongStream rangeClosed(long a, long b)  LongStream                                              Returns LongStream from a(incl) to b(incl)
                int sum()                               IntStream                                               Returns sum of elements in stream
                double sum()                            DoubleStream                                            Returns sum of elements in stream
                IntSummaryStatistics summaryStatistics()  IntStream                                             Returns an object containing numerous stream statistics (avg, min, max, etc)
                LongSummaryStatistics summaryStatistics()  LongStream                                           Returns an object containing numerous stream statistics (avg, min, max, etc)
                DoubleSummaryStatistics summaryStatistics()  DoubleStream                                       Returns an object containing numerous stream statistics (avg, min, max, etc)

            Mapping Streams

                Source stream class     To create: Stream       To create: DoubleStream     To create: IntStream     To create: LongStream
                ===================================================================================================================================
                Stream<T>               map                     mapToDouble()               mapToInt()               mapToLong()
                DoubleStream            mapToObj()              map()                       mapToInt()               mapToLong()
                IntStream               mapToObj()              mapToDouble()               map()                    mapToLong()
                LongStream              mapToObj()              mapToDouble()               mapToInt()               map()


        Summarizing Statistics
            - summaryStatistics() method performs many calculations on the stream:
                - getCount(): gives number of values (long)
                - getAverage(): returns an average value (double) or 0 if teh stream is empty
                - getSum(): returns a sum (double or long)
                - getMin(): returns the smallest number (double, int or long)
                    - if the stream is empty returns the largest numeric value based on the type
                - getMax(): returns the largest number (double, int or long)
                    - if the stream is empty returns the smallest numeric value based on the type

     */

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(7, 11, 21);
        OptionalDouble avg = intStream.average();
        System.out.println(avg.getAsDouble());

        DoubleStream doubleStream = DoubleStream.of(3.14, 2.72, 1.618);
        doubleStream.forEach(System.out::println);

        IntStream rangedIntStream = IntStream.range(2, 5);
        rangedIntStream.forEach(System.out::println);

        rangedIntStream = IntStream.rangeClosed(2, 5);
        rangedIntStream.forEach(System.out::println);

        // mapping example
        Stream<String> objStream = Stream.of("John", "Paul", "George", "Ringo");
        IntStream intStream1 = objStream.mapToInt(s -> s.length());
        intStream1.forEach(System.out::println);

        // flatMap() can also be used
        List<List<Integer>> listOfLists = new ArrayList<>();
        listOfLists.add(Arrays.asList(1, 2, 3));
        listOfLists.add(Arrays.asList(4, 5));
        listOfLists.add(Arrays.asList(6, 7, 8, 9));
        System.out.println(listOfLists);

        IntStream intStream2 = listOfLists.stream().flatMapToInt(convertedStream -> convertedStream // creates a stream
                .stream().mapToInt(n -> n));

        intStream2.forEach(System.out::print);

        // primitive streams using optionals
        OptionalDouble myAvg = IntStream.rangeClosed(2, 7).average();
        myAvg.ifPresent(System.out::println);
        System.out.println("=======");
        System.out.println(myAvg.getAsDouble());
        System.out.println(myAvg.orElseGet(() -> Double.NaN));

        // summarizing statistics
        var intStream4 = IntStream.of(7, 2, -4, 11, 27);
        IntSummaryStatistics stats = intStream4.summaryStatistics();
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());
        System.out.println(stats.getSum());
    }
}
