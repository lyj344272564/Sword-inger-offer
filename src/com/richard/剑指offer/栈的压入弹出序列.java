package com.richard.剑指offer;

import java.util.Stack;

public class 栈的压入弹出序列 {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        int j = 0;
        while (i < pushA.length) {
            if (pushA[i] != popA[j]) {
                stack.push(pushA[i++]);
            } else {
                ++i;
                ++j;
                while (!stack.isEmpty() && stack.peek() == popA[j]) {
                    stack.pop();
                    j++;
                }
            }
        }
        return stack.isEmpty();
    }
}
