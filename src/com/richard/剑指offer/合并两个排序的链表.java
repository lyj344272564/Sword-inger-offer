package com.richard.剑指offer;

public class 合并两个排序的链表 {

    public ListNode Merge(ListNode list1,ListNode list2) {

        ListNode head = new ListNode(-1);
        ListNode cur  = head;

        while (null != list1 && null != list2) {
            if (list1.val <= list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }

        cur.next = null==list1?list2:list1;

        return head.next;
    }
}
