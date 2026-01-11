package com.concurrency;

import java.util.concurrent.*;

public class ScheduledExecutorDemo {
    public static void main(String[] args) {
        ScheduledExecutorService es = Executors.newSingleThreadScheduledExecutor();

        Runnable taskOne = () -> {
            System.out.println("Hello");
        };

        Callable<String> taskTwo = () -> "Hi";

        ScheduledFuture<?> resOne = es.schedule(taskOne, 5, TimeUnit.SECONDS);
        ScheduledFuture<?> resTwo = es.schedule(taskTwo, 6, TimeUnit.MINUTES);

        es.shutdown();

        // taskOne is scheduled 5s in the future
        // taskTwo is scheduled 6s in the future
    }
}
