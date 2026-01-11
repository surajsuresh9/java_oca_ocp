package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

    /*
        Atomic Classes

        Class Name                          Description
        =======================================================================================
        AtomicBoolean                       A boolean value that may be updated automatically
        AtomicInteger                       An int value that may be updated automatically
        AtomicLong                          A long value that may be updated automatically


        Common Atomic Methods

        Method                          Description
        =======================================================================================
        get()                           Retrieves a current value
        set(T newVal)                   Sets new value abd returns new value (equivalent to =)
        getAndSet(T newVal)             Sets new value and returns old value
        incrementAndGet()               Equivalent to ++value
        getAndIncrement()               Equivalent to value++
        decrementAndGet()               Equivalent to --value
        getAndDecrement()               Equivalent to value--

    */


public class AtomicClassesDemo {
    private static AtomicInteger counter = new AtomicInteger(0);
//    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int t = 0; t < 1_000_000; t++) {
                counter.getAndIncrement();
//                counter++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int t = 0; t < 1_000_000; t++) {
                counter.getAndIncrement();
//                counter++;
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("counter: " + counter.get());
    }
}
