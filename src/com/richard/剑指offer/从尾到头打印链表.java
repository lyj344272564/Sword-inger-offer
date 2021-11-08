package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.Stack;

public class 从尾到头打印链表 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();

        ListNode cur = listNode;
        Stack<Integer> stack = new Stack<>();

        while (cur != null) {
            stack.push(cur.val);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }
}

class ListNode{
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode() {
    }
}
