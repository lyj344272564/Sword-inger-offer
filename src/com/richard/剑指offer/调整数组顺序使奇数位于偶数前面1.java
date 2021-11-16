package com.richard.剑指offer;

public class 调整数组顺序使奇数位于偶数前面1 {

    public int[] reOrderArray (int[] nums) {
        if (null==nums || 0==nums.length) {
            return nums;
        }
        //记录已经是奇数的位置
        int j = 0;
        int temp = 0;
        for (int i=0; i<nums.length; i++) {
            temp = nums[i];
            if (nums[i]%2 == 0) {
                continue;
            } else {
                int k = i;
                while (k>j) {
                    //这区间整体向后移动一位
                    nums[k] = nums[k-1];
                    k--;
                }
                nums[k] = temp;
                j++;
            }
        }
        return nums;
    }
}
