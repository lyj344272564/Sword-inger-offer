package com.richard.剑指offer;

import java.util.ArrayList;

public class 和为S的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int[] nums, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        if (0 == nums.length) {
            return res;
        }

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum > target) {
                r--;
            } else if (sum < target) {
                l++;
            } else {
                res.add(nums[l]);
                res.add(nums[r]);
                return res;
            }
        }

        return res;
    }
}
