package com.richard.剑指offer;

import java.util.Arrays;

public class 扑克牌顺子 {

    public boolean IsContinuous(int[] nums) {

        if (null == nums) {
            return false;
        }

        Arrays.sort(nums);

        int k = 0;
        while (0 == nums[k]) {
            k++;
        }

        for (int i=k+1; i<nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                return false;
            }
        }

        return nums[nums.length-1]-nums[k] <= 4;
    }
}
