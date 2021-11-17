package com.richard.剑指offer;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class 字符流中第一个不重复的字符 {

    Map<Character,Integer> map = new HashMap<>();
    Queue<Character> q = new LinkedList<>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            int value = map.get(ch);
            map.put(ch,++value);
        } else {
            map.put(ch,1);
        }
        q.offer(ch);
        while (!q.isEmpty() && map.get(q.peek())>1) {
            q.poll();
        }
    }

    public char FirstAppearingOnce() {
        return q.isEmpty()? '#' : q.peek();
    }
}
