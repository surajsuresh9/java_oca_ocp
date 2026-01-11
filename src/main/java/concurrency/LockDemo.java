package concurrency;

    /*
        Reentrant Lock

        - part of Lock interface which allows manual control over monitors
        - for e.g: it's useful when we want to check if lock is available
          and then maybe do something else in case it's not
        - to protect a part of code call lock() method
           to make it unavailable to other threads while one thread is using it
        - to make it available to other threads can unlock() method


          Lock lock = new ReentrantLock();
//        try {
//            lock.tryLock();
//            // work to be executed one thread at a time
//        } finally {
//            lock.unlock();
//        }

         - this is equivalent to using synchronized block,
           but it gives you more control over the access

       Lock Methods

       Method                                                       Description
       ===============================================================================================================
       void lock()                                                  requires lock and blocks until lock is acquired
       void unlock()                                                releases a lock
       boolean tryLock()                                            requests lock and returns immediately, returns boolean indicating if the lock was successfully acquired
       boolean tryLock(long Timeout, TimeUnit unit)                 requests lock and blocks for specified time or until lock is acquired, returns boolean indicating if the lock was successfully acquired

        - you can release the lock the same number of times it acquired, in other words lock/unlock always works in pairs
        - if you try to lock twice, but release it only once, you'll create an error
        - to make sure to avoid this error use tryLock() in combination with unlock()
            - only if tryLock() return true, call unlock()

    */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    public static void main(String[] args) {
    }
}
