package com.concurrency;

public class MyClass1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread: " + getName() + " is being executed");
    }

    public static void main(String[] args) {
        new MyClass1().start();
        System.out.println("Thread: " + Thread.currentThread().getName() + " is being executed");
    }
}
