package com.richard.剑指offer;

public class 链表中环的入口结点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (null == pHead || null == pHead.next) {
            return null;
        }

        ListNode f = pHead.next;
        ListNode s = pHead;

        while (null != f) {
            s = s.next;
            f = f.next;
            if (null == f) {
                return null;
            }
            f = f.next;
            if (f == s) {
                f = f.next;
                s = pHead;
                while (s != f) {
                    f = f.next;
                    s = s.next;
                }
                return s;
            }
        }
        return null;
    }
}
