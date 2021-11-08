package com.richard.剑指offer;

public class 删除链表的节点 {

    public ListNode deleteNode (ListNode head, int val) {
        // write code here
        ListNode cur = head;

        if (val == head.val) {
            head = head.next;
        }

        while (null != cur) {
            if (val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }
}
