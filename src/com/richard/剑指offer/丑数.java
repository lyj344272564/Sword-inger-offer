package com.richard.剑指offer;

public class 丑数 {

    public int GetUglyNumber_Solution(int n) {
        if (0 == n) {
            return 0;
        }
        int a = 0;
        int b = 0;
        int c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i=1; i<n; i++) {
            int n1 = dp[a] * 2;
            int n2 = dp[b] * 3;
            int n3 = dp[c] * 5;
            int min = Math.min(n1,Math.min(n2,n3));
            dp[i] = min;
            if (n1 == min) {
                a++;
            }
            if (n2 == min) {
                b++;
            }
            if (n3 == min) {
                c++;
            }
        }
        return dp[n-1];
    }
}
