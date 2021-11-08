package com.richard.剑指offer;

import java.util.Stack;

public class 包含min函数的栈 {
    Stack<Integer> stackData = new Stack<>();
    Stack<Integer> stackMin = new Stack<>();

// 每次不需要都压入min
//    // 只有更小的时候min才会入栈    但是data无论五河都会入栈
//    public void push(int node) {
//        if (stackMin.isEmpty()) {
//            stackMin.push(node);
//        } else if (stackMin.peek() >= node){
//            stackMin.push(node);
//        }
//        stackData.push(node);
//    }
//
//    public void pop() {
//        int val = stackData.pop();
//        if (val == stackMin.peek()) {
//            stackMin.pop();
//        }
//    }
//
//    public int top() {
//        return stackData.peek();
//    }
//
//    public int min() {
//        return stackMin.peek();
//    }

    public void push(int node) {
        if (stackMin.isEmpty()) {
            stackMin.push(node);
        } else {
            if (stackMin.peek() >= node) {
                stackMin.push(node);
            } else {
                stackMin.push(stackMin.peek());
            }
        }
        stackData.push(node);
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();
    }

    public int top() {
        return stackData.pop();
    }

    public int min() {
        return stackMin.peek();
    }
}
