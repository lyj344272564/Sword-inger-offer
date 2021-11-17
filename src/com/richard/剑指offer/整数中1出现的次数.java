package com.richard.剑指offer;

public class 整数中1出现的次数 {

    public int NumberOf1Between1AndN_Solution(int n) {
        return hasOne(n);
    }

    public int hasOne(int n) {
        if (0 == n) {
            return 0;
        }
        // 将数字转为字符串
        String number = String.valueOf(n);
        // 获取最高位
        int high = number.charAt(0) - '0';
        // 获取最接近的100..00
        int pow = (int)Math.pow(10, number.length()-1);
        // 获取剩余数字
        int left = n - high * pow;
        if (1 == high) {
            return  hasOne(pow-1) + left + 1 + hasOne(left);
        } else {
            return pow + high * hasOne(pow-1) + hasOne(left);
        }
    }
}
