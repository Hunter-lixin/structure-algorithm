package com.LeetCode;

import java.util.Stack;

public class MinStack {


    private Stack<Integer> dataStack;
    private Stack<Integer> minDataStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        dataStack = new Stack<>();
        minDataStack = new Stack<>();
    }

    public void push(int x) {
        dataStack.push(x);
        if (minDataStack.isEmpty()) {
            minDataStack.push(x);
        } else {
            int min = minDataStack.peek();
            minDataStack.push(Math.min(min, x));
        }
    }

    public void pop() {
        dataStack.pop();
        minDataStack.pop();
    }

    public int top() {
        return dataStack.peek();
    }

    public int getMin() {
        return minDataStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
