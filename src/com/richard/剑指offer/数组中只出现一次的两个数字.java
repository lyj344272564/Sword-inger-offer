package com.richard.剑指offer;

public class 数组中只出现一次的两个数字 {

    public int[] FindNumsAppearOnce (int[] nums) {
        int sum = 0;
        for (int x : nums) {
            sum ^= x;
        }

        int mask = 1;
        // 寻找最右面的1
        while (0 == (mask&sum)) {
            mask <<= 1;
        }

        int a = 0;
        int b = 0;

        for (int x : nums) {
            if (0 == (mask&x)) {
                a ^= x;
            } else {
                b ^= x;
            }
        }
        if (a>b) {
            int temp = a;
            a = b;
            b = temp;
        }
        return new int[]{a,b};
    }
}
