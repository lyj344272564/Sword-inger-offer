package com.richard.剑指offer;

public class 调整数组顺序使奇数位于偶数前面2 {

    public int[] reOrderArrayTwo (int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        while (l < r) {
            while (l<r && nums[l]%2!=0) {
                l++;
            }
            while (l<r && nums[r]%2==0) {
                r--;
            }
            if (l<r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        return nums;
    }
}
