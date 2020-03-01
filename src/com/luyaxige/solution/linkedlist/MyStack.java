package com.luyaxige.solution.linkedlist;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        System.out.println("push " + x);
        queue.add(x);
        int size = queue.size();
        for (int i = 0; i < size - 1; i++) {
            queue.offer(queue.remove());
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {

        System.out.println("pop "+ top());
        return queue.remove();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.element();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }

    public void printQueue() {
        System.out.print("[");
        for (Integer element: queue) {
            if(element != top()) System.out.print(", ");
            System.out.print(element);
        }
        System.out.println("]");
    }

    public void checkMyStack() {
        push(1);
        push(2);
        push(3);
        printQueue();
        pop();
        top();
        empty();
        printQueue();
    }
}
