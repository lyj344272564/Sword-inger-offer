package com.richard.剑指offer;

public class 两个链表的第一个公共结点 {

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;

        while (p1 != p2) {
            p1 = null==p1?pHead2:p1.next;
            p2 = null==p2?pHead1:p2.next;
        }
        return p1;
    }
}
