package com.richard.剑指offer;

import java.util.*;

public class 滑动窗口的最大值 {

    public ArrayList<Integer> maxInWindows(int [] num, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == num || k<1 || k>num.length) {
            return res;
        }
        // 存储的是下标
        LinkedList<Integer> qmax = new LinkedList<>();

        for (int i=0; i<num.length; i++) {
            while (!qmax.isEmpty() && num[qmax.peekLast()] <= num[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            // 判断窗口大小
            if (qmax.peekFirst() == i-k) {
                qmax.pollFirst();
            }
            if (i >= k-1) {
                res.add(num[qmax.peekFirst()]);
            }
        }

        return res;
    }
}
