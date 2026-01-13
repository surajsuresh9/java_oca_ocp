package com.streams;

import java.util.List;
import java.util.stream.Stream;

public class StreamDemo {

    /*

            What is a Stream?
                - a stream in Java is a sequence of data

            What is a Pipeline?
                - stream pipeline is a set of operations that run on the stream to produce the result
                - you can think of pipeline as an assembly line in the factory
                    - every line has a beginning (source)
                    - after that one by one element, each element in the line is processed (intermediate operations)
                    - finally, we get the result (terminal operation)
                - data in the stream is not generated up front
                    - rather, each element is created when needed -> lazy evaluation

                - Source:
                    - where the stream comes from
                - Intermediate operations:
                    - transforms teh stream into another stream
                    - there can be as many (or as few) of these operation
                    - intermediate operations don't run until the terminal operation runs(lazy)
                - Terminal operation:
                    - produces a result, and can be used only once
                    - after the terminal operation completes, stream is no longer valid

                - Stream pipeline Schema
                    Source  -->  Intermediate   -->  terminal
                                  operations         operations

                - Stream Creation Methods

                Method                                                  Finite?             Description
                ====================================================================================================================================================
                Stream.empty                                            Yes                 Creates stream with zero elements
                Stream.                                                 Yes                 Creates stream with elements listed in varargs
                coll.stream()                                           Yes                 Creates stream from Collection
                coll.parallelStream()                                   Yes                 Creates parallel stream from Collection
                Stream.generate(supplier)                               No                  Creates stream by calling Supplier for each element upon request
                Stream.iterate(speed, unary operator)                   No                  Creates stream by using seed for first element and then call UnaryOperator for each subsequent element
                Stream.iterate(speed, predicate, unary operator)        Depends             Same as before, but stops if Predicate returns false

     */

    public static void main(String[] args) {
        // creating finite streams
        Stream<String> empty = Stream.empty();
        Stream<Integer> singleElement = Stream.of(1);
        Stream<Integer> fromArray = Stream.of(1, 2, 3);

        // converting Collection to stream
        var list = List.of("a", "b", "c");
        Stream<String> fromList = list.stream();

        // parallel stream (operations are done in parallel rather than in sequence)
        Stream<String> fromListparallel = list.parallelStream();

        // creating infinite streams
        Stream<Double> randoms = Stream.generate(Math::random); // supplier
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 2); // 1-seed, 2-unary operator

        // these streams are infinite, they generate values ad infinitum
        randoms.forEach(System.out::println);

        // operations like limit() can turn infinite tream into finite ones

        // create odd numbers less than 50
        Stream<Integer> oddNumbersUnder50 = Stream.iterate(1, n -> n < 50, n -> 50);//  1-seed, 2-predicate that can terminate stream when false is returned, 3-unary operator

    }
}
