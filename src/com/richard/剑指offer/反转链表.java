package com.richard.剑指offer;

public class 反转链表 {
    public ListNode ReverseList(ListNode head) {
        if (null == head) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;

        while (null != cur) {
            ListNode next = cur.next;;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
