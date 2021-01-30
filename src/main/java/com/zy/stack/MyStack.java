package com.zy.stack;

import java.util.Deque;
import java.util.LinkedList;

public class MyStack {

    private Deque<Integer> deque;

    /** Initialize your data structure here. */
    public MyStack() {
        deque = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.push(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return deque.pop();
    }

    /** Get the top element. */
    public int top() {
        return deque.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }

}
