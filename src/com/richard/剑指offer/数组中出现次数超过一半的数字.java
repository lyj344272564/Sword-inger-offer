package com.richard.剑指offer;

public class 数组中出现次数超过一半的数字 {

    public int MoreThanHalfNum_Solution(int[] nums) {

        int leader = 0;
        int count = 0;
        for (int x : nums) {
            if (0 == count) {
                leader = x;
            }
            count += x==leader ? 1 : -1;
        }
        return leader;
    }
}
