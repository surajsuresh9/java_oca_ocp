package com.concurrency;

public class SleepInterrupt {
    public static void main(String[] args) {
        Thread sleeper = new Thread(() -> {
            try {
                System.out.println("Going to sleep for 3 seconds");
                Thread.sleep(3000);
                System.out.println("Woke up after 3 seconds");
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted during sleep");
            }
        });
        sleeper.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        sleeper.interrupt();
    }
}
