package com.richard.剑指offer;

public class 剪绳子 {

    public int cutRope(int target) {

        if (target <= 3) {
            return 1 * (target - 1);
        }

        int res = 1;
        // 分出两个2
        if (target % 3 == 1) {
            res *= 4;
            target -= 4;
        }
        // 分出一个2
        if (target % 3 == 2) {
            res *= 2;
            target -= 2;
        }

        while (target > 0) {
            res *= 3;
            target -= 3;
        }

        return res;

    }
}
