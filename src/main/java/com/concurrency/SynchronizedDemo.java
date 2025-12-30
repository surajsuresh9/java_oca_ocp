package com.concurrency;

public class SynchronizedDemo {

    /*
         Synchronized Access
            - atomic classes protect single variable
            - synchronized access protects series of commands (block)
            - a structure called monitor (or lock) supports mutual exclusion(mutex - only 1 thread has access to shared resource)
                - while the block is running, no other thread can interfere
            - any object can be used as a monitor (existing or new one)
            - when thread tries to run the block it first checks if any other thread is running it
                - if lock is not available, the thread will transition to BLOCKED state
                - after the thread 'acquires the lock', the single thread will enter the block
                - while the block is executed all other threads will be prevented from entering


            // synchronized block
            var lock = new Object();
            synchronized (lock) {
                // code which need to be executed
                // one thread at a time
             }

            // synchronized methods

            void doSomething(){
                synchronized(this) { // current class (this) is used as a block
                    // work to be executed one thread at a time
                }
            }

            // alternate
            synchronized void doSomething() { // method is marked as synchronzied
                    // work to be executed one thread at a time
                }

     */

    public static void main(String[] args) {

    }
}
