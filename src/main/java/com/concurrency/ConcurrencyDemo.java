package com.concurrency;

public class ConcurrencyDemo {
    /*
            Thread:
                - smallest unit of execution that can be scheduled bu the OS

            Process:
                - group of associated threads that execute in the same env
                    - single-thread-process (only one thread)
                    - multi-thread-process (more than one thread)

            Shared Env:
                - threads in the same process share the same memory space
                - these threads can communicate directly with each other

            Task:
                - single unit of work performed by the thread
                - usually implemented as a lambda expression
                - thread can complete multiple independent tasks, but only one at a time

            Shared Memory:
                - static variables, plus instance and local variables passed to a thread
                - remember, static variables are shared among all instances of a class
                - if one thread updates the value of static member, this information becomes immediately available
                  for other threads within the process

            Thread Concurrency:
                - property of executing multiple threads and processes at the same time
                - number of threads can exceed number of available CPUs
                    - in that case, OS uses thread scheduler to determine which threads should
                      be currently executing
                - context switch occurs when the thread's allocated time is complete, but the thread has not finished processing
                    - it's a process of storing thread's current state and later restoring the state
                    - good thread scheduler minimises the number of context switches
                - thread priority is a numeric value associated with a thread
                    - used by tread scheduler to determine which thread should be executing

             Thread Lifecycle:
                - after a thread is created, it exists in 1 of 6 states
                    - NEW: created but not started
                    - RUNNABLE: running or able to run
                    - TERMINATED: task completed
                    - BLOCKED: waiting to enter synchronized block
                    - WAITING: waiting indefinitely until notified
                    - TIMED_WAITING: waiting a specified time

             How to create a thread?
                - there are 3 ways to create a thread
                    - extend Thread class
                    - implement Runnable interface
                    - implement Callable interface (requires ExecutorService)


            Concurrency API:
            - cane be used by importing java.util.concurrent pkg
            - this pkg includes ExecutorService interface
                - this interface defines services which create and manage threads
                - including features like thread pooling, thread scheduling, etc

            Future<V> instance:
            - There are 2 wats to execute Runnable task
                - using execute(Runnable task) method
                - using submit(Callable task) method
            - the difference is that submit() return a value
                - this value is instance of a special interface called Future<V>
                - this instance can be used to determine the result of the execution

            Future<V> instance methods:
                - boolean isDone()
                    - returns true if task was completed, threw exception or was cancelled

                - boolean isCancelled()
                    - returns true if task was cancelled before completed normally

                - boolean cancel(boolean mayInterruptIfRunning)
                    - attempts to cancel the execution of the task, returns true, if it was cancelled

                - V get()
                    - retrieves the result of the task

                - V get(long timeout, TimeUnit unit)
                    - retrieves the result of the task, waiting specified amount of time
                    - if the result is not ready by that time, checked TimeoutException will be thrown

            Callable Interface
                - similar to Runnable, except:
                    - method you need to implement is called call()
                    - call() method returns a value and can throw a checked exception
                - ExecutorService includes overloaded version of the submit() method
                    - you can pass Callable object to submit() and get Future<T> instance
                - When passing Runnable, get() return null if the task is complete
                    - with Callable, get() returns the matching generic type


            Scheduling Tasks
                - to schedule tasks we use ScheduledExecutorService interface with

                    - schedule(Callable<V> callable, long delay, TimeUnit unit)
                      creates and executes Callable task after given delay

                    - schedule(Runnable task, long delay, TimeUnit unit)
                      creates and executes Runnable task after given delay

                    - scheduleAtFixedRate(Runnable task, long initDelay, long period, TimeUnit unit)
                      creates and executes Runnable task after initial delay and creating new task
                      ever period value that passes

                    - scheduleAtFixedDelay(Runnable task, long initDelay, long period, TimeUnit unit)
                      creates and executes Runnable task after initial delay and subsequently with given delay
                      between termination of one and execution of the next one

            Scheduling Thread Pool
                - thread pool is a group of pre-instantiated reusable threads
                  available to perform a set of arbitrary tasks

                ExecutorService newCachedThreadPool()
                    creates thread pool that creates new threads as needed, but reuses previously
                    constructed threads when they are available

                ExecutorService newFixedThreadPool(int noOfThreads)
                    creates thread pool that reuses fixed number of threads operating off shared unbounded queue

                ExecutorService newScheduledThreadPool(int noOfThreads)
                    creates thread pool that can schedule commands to run after given delay or execute periodically

     */
}
