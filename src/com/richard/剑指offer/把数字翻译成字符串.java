package com.richard.剑指offer;

public class 把数字翻译成字符串 {

    public int solve(String s) {
        if (0 == s.length() || s.charAt(0)=='0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i=1; i<dp.length; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i-1];
            }
            int num = (s.charAt(i-1)-'0')*10 + (s.charAt(i)-'0');
            if (num>=10 && num<=26) {
                if (1== i) {
                    dp[i] += 1;
                } else {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length()-1];
    }
}
