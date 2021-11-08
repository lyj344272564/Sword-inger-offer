package com.richard.剑指offer;

public class 删除链表中重复的结点 {

    public ListNode deleteDuplication(ListNode pHead) {

        if (null == pHead) {
            return null;
        }

        ListNode dum = new ListNode(-1);
        dum.next = pHead;
        ListNode cur = dum;

        // cur.next是判断是否走到尽头   cur.next.next是指判断当前数字的后一个数字是否和在后面的一个数字重复假设就剩一个数字  则不会重复
        while (null != cur.next && null != cur.next.next) {
            // cur指的是确定没有重复元素的最后一个
            if (cur.next.val == cur.next.next.val) {
                int x = cur.next.val;
                // 去重 因为不止有两个所以需要用while来判断去重
                while (null != cur.next && x == cur.next.val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dum.next;
    }
}
