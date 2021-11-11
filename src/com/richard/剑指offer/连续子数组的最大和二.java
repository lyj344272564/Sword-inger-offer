package com.richard.剑指offer;

public class 连续子数组的最大和二 {

    public int[] FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int[] dp = new int[array.length];

        dp[0] = array[0];

        int maxLength = 1;
        int maxSum = array[0];
        int left = 0;
        int right = 0;
        int snapLeft = 0;
        int snapRight = 0;

        for (int i=1; i<=array.length-1; i++) {
            right++;
            // 比较当前和前一个比较
            dp[i] = Math.max(array[i]+dp[i-1],array[i]);
            // 只要dp[i-1]小于0那么就会产生一次
            if (array[i] + dp[i - 1] < array[i]) {
                left = right;
            }
            if (dp[i]>maxSum || dp[i]==maxSum && (right-left+1)>maxLength) {
                snapLeft = left;
                snapRight = right;
                maxLength = right - left + 1;
                maxSum = dp[i];
            }
        }

        int[] res = new int[maxLength];
        int idx = 0;
        for (int i=snapLeft; i<=snapRight; i++) {
            res[idx++] = array[i];
        }

        return res;

    }
}
