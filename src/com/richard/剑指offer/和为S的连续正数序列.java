package com.richard.剑指offer;

import java.util.ArrayList;

public class 和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (0 == sum) {
            return res;
        }
        for (int i=1,j=1,s=1; i<=sum; i++) {
            // 若小于每次把后面的一个数加上
            while (s < sum) {
                s += ++j;
            }
            if (s == sum && j-i+1>1) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int k=i; k<=j; k++) {
                    list.add(k);
                }
                res.add(list);
            }
            // 向后移一位
            s -= i;
        }
        return res;
    }
}
