package com.concurrency;

public class ConcurrentCollections {

    /*
            Using Collections with Threads
                - multiple threads performing operations on the same collection can be dangerous
                - memory consistency error
                    - two threads have inconsistent views of what should be the same data
                    - for e.g: one thread removes the element, but the other thread "didn't get the memo"
                      and it behaves like the element is still there
                    - to avoid these kind of errors we have to use thread-safe collections
                    - these are provided via concurrent classes

            Class Name                          Java Collection Interfaces
            =============================================================================================
            ConcurrentHashMap                   Map, ConcurrentMap
            ConcurrentLinkedQueue               Queue
            ConcurrentSkipListMap               Map, SortedMap, NavigableMap, ConcurrentMap, ConcurrentNavigableMap
            ConcurrentSkipListSet               Set, SortedSet, NavigableSet
            CopyOnWriteArrayList                List
            CopyOnWriteArraySet                 Set
            LinkedBlockingQueue                 Queue, BlockingQueue

            Synchronized Collection Methods
            ===============================
            synchronizedCollection(Collection <T> C)
            synchronizedList(List<T> list)
            synchronizedMap(Map<K,V> m)
            synchronizedNavigableMap(NavigableMap<K,V> m)
            synchronizedNavigableSet(NavigableSet<T> s)
            synchronizedSet(Set<T> s)
            synchronizedSortedMap(SortedMap<K,V> m)
            synchronizedSortedSet(SortedSet<T> s)

           Concurrency Problems
            - Liveness
                - the ability of an app to be able to execute in a timely manner
                - liveness problems occurs when apps become unresponsive ('stuck')
                    - these problems are a result of thread entering BLOCKING or WAITING state
                    - forever or altering between entering/ exiting these states
                - deadlock, starvation,  livelock

            - Deadlock
                - 2 or more threads are blocked forever
                  because each thread is waiting on the other to complete

            - Starvation
                - a single thread is perpetually denied access to a shared resource or a lock
                - the thread is still active, but is unable to complete its work
                    - because other threads(s) are constantly taking the resource it's trying to access

            - Livelock
                - 2 or more threads are conceptually blocked forever
                    - even though each of them is active and is trying to complete its task
                - this is special case of resource starvation:
                    - 2 or more threads actively try to acquire a set of locks, and since they are unable to do so, the process is restarted
                - in practice, livelock is difficult to detect
                  as threads in livelock appear active and responsive, but actually they are stuck in an endless state

            - Race Condition
                - 2 tasks that should be completed sequentially are completed at the same time
                - most common e.g: is creation of unique username
                    - either both users will create an account with same username
                    - or neither user will be able to create an account and will get error
                    - or one user will be allowed a username, and the other will get an error
                - neither of these outcomes is desirable




     */
}
