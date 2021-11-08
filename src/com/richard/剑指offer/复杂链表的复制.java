package com.richard.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 复杂链表的复制 {

    public RandomListNode Clone(RandomListNode pHead) {
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        RandomListNode cur = pHead;
        while (null != cur) {
            map.put(cur,new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = pHead;
        while (null != cur) {
            // 指向new出来的cur的下一个new
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }

        return map.get(pHead);
    }
}
class RandomListNode{
    int label;
    RandomListNode next;
    RandomListNode random;

    public RandomListNode() {
    }

    public RandomListNode(int label) {
        this.label = label;
    }
}
