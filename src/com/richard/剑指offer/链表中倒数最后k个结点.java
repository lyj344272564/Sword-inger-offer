package com.richard.剑指offer;

public class 链表中倒数最后k个结点 {

    public ListNode FindKthToTail (ListNode pHead, int k) {
        ListNode f = pHead;
        ListNode s = pHead;
        while (k-- != 0) {
            if (null == f) {
                return null;
            }
            f = f.next;
        }

        while (null != f) {
            f = f.next;
            s = s.next;
        }

        return s;
    }
}
