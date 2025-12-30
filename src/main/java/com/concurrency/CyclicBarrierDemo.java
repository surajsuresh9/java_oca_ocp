package com.concurrency;

/*
    Cyclic Barrier
    - Cyclic Barrier class takes in its constructor a limit value
        - indicating the number of threads to wait fot
    - as each thread finishes it calls the await() method on the cyclic barrier
    - once the specific number of threads have each called await(), the barrier is released
      and can continue

 */

import com.sun.security.jgss.InquireSecContextPermission;

import javax.print.attribute.standard.MediaSize;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3); // barrier for 3 parties
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " is performing first part of the work");

            try {
                cyclicBarrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            // code to follow will be performed only after 3 threads finish
            // with the execution of the code above

            System.out.println(name + " is performing the remaining work after the barrier");
        };

        Thread worker1 = new Thread(runnable, "Worker-1");
        Thread worker2 = new Thread(runnable, "Worker-2");
        Thread worker3 = new Thread(runnable, "Worker-3");
        Thread worker4 = new Thread(runnable, "Worker-4");

        worker1.start();
        worker2.start();
        worker3.start();
        worker4.start();

    }
}

