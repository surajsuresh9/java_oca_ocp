package com.streams;

import java.util.Optional;

/*
        What is an Optional?
            - Optional is a container object that is used to contain values
            - think of it as a box, which can be either empty or contain something
                - but the Optional object itself (the box) is never null
            - there are methods to deal with optional values without explicit null checks
                - otherwise we could get NullPointerException if not handled properly
            - we have to import java.util.Optional


        Common Optional Methods

        Method                           When Optional is empty                  When Optional contains a value
        ================================================================================================================
        get()                            Throws exception                        Returns value
        ifPresent(Consumer c)            Does nothing                            Calls Consumer with value
        isPresent()                      Returns false                           Returns true
        orElse(T other)                  Returns other                           Returns value
        orElseGet(Supplier s)            Returns result of Supplier              Returns value
        orElseThrow()                    NoSuchElementException                  Returns value
        orElseThrow(Supplier s)          Throws exception in Supplier            Returns value

*/
public class OptionalDemo {
    public static void main(String[] args) {
        System.out.println(average(10, 20, 30));
        System.out.println(average());

        // we can check if the Optional is empty
        Optional<Double> optional = average(10, 20, 30);
        if (optional.isPresent()) {
            System.out.println("average: " + optional.get());
        }

        Optional<Double> optional2 = average();
//        System.out.println("average: " + optional2.get()); // NoSuchElementException

        // good practice is to use empty() when value is null
        Double val = null;
        Optional<Double> myOptional = (val == null) ? Optional.empty() : Optional.of(val);

        // there is a factory method that does this
        // if value is null, Optional.empty() is returned
        Optional<Double> myNullableOptional = Optional.ofNullable(val);

        // lambda expression
        Optional<Double> optional3 = average(10, 20, 30);
        optional3.ifPresent(System.out::println);

        Optional<Double> myOptional2 = average();
        System.out.println(myOptional2.orElse(Double.NaN));

        // supplier must provide a double
        System.out.println(myOptional2.orElseGet(() -> Math.random()));

        // throw exceptions
//        System.out.println(myOptional2.orElseThrow());// NoSuchElementException
//        System.out.println(myOptional2.orElseThrow(() -> new IllegalStateException()));


    }

    static Optional<Double> average(int... nyNums) {
        if (nyNums.length == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (int num : nyNums) {
            sum += num;
        }
        return Optional.of((double) sum / nyNums.length);
    }

}
