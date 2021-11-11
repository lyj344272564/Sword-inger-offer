package com.richard.剑指offer;

public class 数字序列中某一位的数字 {

    public int findNthDigit (int n) {
        // 从1开始但是还有0
        n--;
        // 减去0
        n++;
        int i = 1;
        // 这一位有多少个数
        long s = 9;
        // 这一位数的刚开始的数字
        int base = 1;
        // 确定是几位数
        while (n > i*s) {
            n -= s*i;
            i++;
            s *= 10;
            base *= 10;
        }
        // 确定是几位数的第几个数
        long num = base + (n-1)/i;
        // 属于那个数的第几位
        return Long.toString(num).charAt((n-1)%i)-'0';
    }
}
