package com.richard.剑指offer;

public class 二进制中1的个数 {

    public int NumberOf1(int n) {
        int res = 0;
        while (0 != n) {
            // 每次寻找最后一个1  & 操作不会改变1的个数
            res += n&1;
            n >>>= 1;
        }
        return res;
    }
}
