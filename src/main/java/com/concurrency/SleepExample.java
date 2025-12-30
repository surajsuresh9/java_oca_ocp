package com.concurrency;

public class SleepExample {
    public static void main(String[] args) {
        Thread evenThread = new Thread(() -> {
            for (int i = 0; i < 10; i += 2) {
                System.out.println("Even: " + (i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread oddThread = new Thread(() -> {
            for (int i = 1; i < 10; i += 2) {
                System.out.println("Odd: " + (i));
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        evenThread.start();
        oddThread.start();
    }
}
