package com.collections.deque;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    /*
            - Deque used as a Stack
                - implemented by LinkedList and ArrayDeque
                - adds elements in the front, reads from the back
                    - LIFO: Last In, First Out
                - deque specific methods
                    - peek(), push(E e), poll()
                - methods inherited from Collection
                    - element(), add(E e), remove()

             - What is a Stack?
                - LIFO data structure

             - Deque Interface as Double Ended Queue
                - proper methods
                    - peekFirst(), offerFirst(E e), pollFirst()
                    - peekLast(), offerLast(E e), pollLast()
                - methods inherited from Collection
                    - getFirst(), addFirst(E e), removeFirst()
                    - getLast(), addLast(E e), removeLast()
     */

    public static void main(String[] args) {
        Deque<String> colors = new ArrayDeque<>();
        colors.push("blue");
        colors.push("green");
        colors.push("red");
        colors.push("yellow");
        System.out.println(colors);
        System.out.println(colors.peek());
        colors.pop();
        System.out.println(colors.peek());
        colors.pop();
        colors.pop();
        colors.pop();
        System.out.println(colors.peek());

        Deque<Integer> nums = new LinkedList<>();
        nums.addFirst(9);
        nums.offerFirst(-11);
        nums.addLast(5);
        System.out.println(nums);
        System.out.println(nums.getFirst());
        System.out.println(nums.peekLast());
        nums.pollFirst();
        System.out.println(nums);
        System.out.println(nums.getFirst());
        System.out.println(nums.peekLast());
    }
}
