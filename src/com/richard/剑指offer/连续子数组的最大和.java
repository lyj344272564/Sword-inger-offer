package com.richard.剑指offer;

public class 连续子数组的最大和 {

    public int FindGreatestSumOfSubArray(int[] array) {
        if (null == array) {
            return 0;
        }
        int s = 0;
        int res = Integer.MIN_VALUE;

        for (int x : array) {
           if (s<0) {
               s = 0;
           }
           s+=x;
           res = Math.max(res,s);
        }
        return res;
    }
}
