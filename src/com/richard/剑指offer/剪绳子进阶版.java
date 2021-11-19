package com.richard.剑指offer;

public class 剪绳子进阶版 {

    public long pow (long cnt) {
        // 如何快速计算3的cnt次幂?
        if (cnt == 0) return 1;
        if (cnt == 1) return 3;
        long part = pow(cnt / 2);
        if (cnt % 2 == 0) return part * part % 998244353;
        return 3 * part * part % 998244353;
    }
    public long cutRope (long number) {
        // write code here
        if (number == 2) return 1;
        if (number == 3) return 2;
        long cnt = number / 3;
        if (number % 3 == 0) {
            return pow(cnt) % 998244353;
        } else if (number % 3 == 1) {
            cnt--;
            return 2 * 2 * pow(cnt) % 998244353;
        } else {
            return 2 * pow(cnt) % 998244353;
        }
    }
}
