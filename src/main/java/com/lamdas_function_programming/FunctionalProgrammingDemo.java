package com.lamdas_function_programming;

public class FunctionalProgrammingDemo {

    /*
        - Common Function Interfaces for Primitives

            Functional Interface               Return Type                 Abstract Method Signature
            ============================================================================================

            BooleanSupplier                    boolean                     getAsBoolean()
            DoubleSupplier                     double                      getAsDouble()
            IntSupplier                        int                         getAsInt()
            LongSupplier                       long                        getAsLong()

            DoubleConsumer                     void                        accept(double a)
            IntConsumer                        void                        accept(int a)
            LongConsumer                       void                        accept(long a)

            DoublePredicate                    boolean                     test(double a)
            IntPredicate                       boolean                     test(int a)
            LongPredicate                      boolean                     test(long a)

            DoubleFunction<R>                  R                           apply(double a)
            IntFunction<R>                     R                           apply(int a)
            LongFunction<R>                    R                           apply(long a)

            DoubleUnaryOperator                double                      applyAsDouble(double a)
            IntUnaryOperator                   int                         applyAsInt(int a)
            LongUnaryOperator                  long                        applyAsLong(long a)

            DoubleBinaryOperator               double                      applyAsDouble(double a, double b)
            IntBinaryOperator                  int                         applyAsInt(int a, int b)
            LongBinaryOperator                 long                        applyAsLong(long a, long b)

    ==================================================================================================================
    ==================================================================================================================

        - Primitive Specific Function Interfaces

            Functional Interface               Return Type                 Abstract Method Signature
           ============================================================================================

            ToDoubleFunction<T>                double                      applyAsDouble(T t)
            ToIntFunction<T>                   int                         applyAsInt(T t)
            ToLongFunction<T>                  long                        applyAsLong(T t)

            ToDoubleBiFunction<T,U>            double                      applyAsDouble(T t, U u)
            ToIntBiFunction<T,U>               int                         applyAsInt(T t, U u)
            ToLongBiFunction<T,U>              long                        applyAsLong(T t, U u)

            DoubleToIntFunction                int                         applyAsInt(double a)
            DoubleToLongFunction               long                        applyAsLong (double a)
            IntToDoubleFunction                double                      applyAsDouble(int a)
            IntToLongFunction                  long                        applyAsLong(int a)
            LongToDoubleFunction               double                      applyAsDouble(long a)
            LongToIntFunction                  int                         applyAsInt(long a)

            ObjDoubleConsumer<T>               void                        accept(T t, double a)
            ObjIntConsumer<T>                  void                        accept(T t, int a)
            ObjLongConsumer<T>                 void                        accept(T t, long a)

     */
}
