package com.lamdas_function_programming;

import java.time.LocalDateTime;
import java.util.function.*;

public class FunctionalInterfaceDemo {
    /*
        - What is a functional interface
            - an interface which has exactly 1 abstract method
            - functional interface can be annotated with @FunctionalInterface
            - Java provides many pre-defined functional interfaces
                - Supplier, Consumer, Function, Predicate, etc.


        - Predicate
            - Predicate is a pre-defined interface provided by Java
            - imported from java.util.function
            - has 1 abstract method boolean test(T)

        - java.util.function pkg
            - this leads to a paradigm usually referred to as functional programming

        Functional Interface            Method Signature            Return Type
        ========================================================================
        Supplier<T>                     get()                       T
        Consumer<T>                     accept(T)                   void
        BiConsumer<T,U>                 accept(T,U)                 void
        Predicate<T>                    test(T)                     boolean
        BiPredicate<T,R>                test(T, U)                  boolean
        Function<T, R>                  apply(T)                    R
        BiFunction<T, U, R>             apply(T, U)                 R
        UnaryOperator<T>                apply(T)                    T
        BinaryOperator<T,T>             apply(T, T)                 T

    - Helper Methods provided by F.I

        - Consumer
            - andThen()

        - Function
            - andThen()
            - compose()

        - Predicate
            - and()
            - or()
            - negate()

     */

    public static void main(String[] args) {
        Supplier<LocalDateTime> dtImpl = () -> LocalDateTime.now();
        System.out.println(dtImpl.get());

        // Consumer, BiConsumer
        Consumer<String> greet = s -> System.out.println("Hello: " + s);
        greet.accept("John Wayne");

        BiConsumer<String, Integer> greet2 = (n, a) -> System.out.println(n + " is " + a + " years old");
        greet2.accept("John Wayne", 31);

        // Predicate, BiPredicate
        Predicate<Integer> greaterThan10 = n -> n > 10;
        System.out.println(greaterThan10.test(10));

        BiPredicate<Integer, Integer> greaterThan = (n1, n2) -> n1 > n2;
        System.out.println(greaterThan.test(10, 5));

        //Function, BiFunction
        Function<Integer, Double> sq = n -> (double) n * n;
        System.out.println(sq.apply(6));

        BiFunction<String, Integer, String> concat = (s, i) -> s + i;
        System.out.println(concat.apply("John", 25));

        // UnaryOperator
        UnaryOperator<Integer> negative = n -> -n;
        System.out.println(negative.apply(5));

        UnaryOperator<String> shout = s -> s.toUpperCase();
        System.out.println(shout.apply("john"));

        // BinaryOperator
        BinaryOperator<Double> add = (a, b) -> a + b;
        System.out.println(add.apply(1.5, 3.7));

        BinaryOperator<String> con = String::concat;
        System.out.println(con.apply("John", "Wayne"));

        // Helper methods
        // Consumer
        Consumer<String> g1 = (s) -> System.out.println("Hello: " + s);
        Consumer<String> g2 = (s) -> System.out.println("Bye: " + s);
        Consumer<String> g3 = g1.andThen(g2);
        g3.accept("John");
        // or
        g1.andThen(g2).accept("John");

        // Function
        Function<Integer, Integer> sqaure = n -> n * n;
        Function<Integer, Integer> triple = n -> 3 * n;
        Function<Integer, Integer> f1 = sqaure.andThen(triple);
        Function<Integer, Integer> f2 = sqaure.compose(triple);

        System.out.println(f1.apply(5));
        System.out.println(f2.apply(5));

        // Predicate
        Predicate<Integer> gt10 = n -> n > 10;
        Predicate<Integer> lt20 = n -> n < 20;
        Predicate<Integer> p1 = gt10.and(lt20);
        Predicate<Integer> p2 = gt10.or(lt20);
        Predicate<Integer> p3 = lt20.negate();
        System.out.println(p1.test(5) + " " + p2.test(5) + " " + p3.test(5));
    }
}
