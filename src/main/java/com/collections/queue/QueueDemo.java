package com.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    /*
            - What is a queue?
                - Queue Interface
                    - implemented by LinkedList class
                    - adds elements in teh back, reads from the front
                        - FIFO: first in, first out
                    - queue specific methods
                        - peek(), offer(E e), poll()
                    - Collection inherited methods
                        - element(), add(E e), remove()

     */
    public static void main(String[] args) {
        Queue<String> colors = new LinkedList<>();
        colors.offer("blue");
        colors.offer("green");
        colors.offer("red");
        colors.offer("yellow");
        System.out.println(colors);
        System.out.println(colors.peek());
        colors.poll();
        System.out.println(colors);
        System.out.println(colors.peek());
    }
}
