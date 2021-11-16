package com.richard.剑指offer;

public class 矩形覆盖 {

    public int rectCover(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int first = 1;
        int second = 2;
        int res = 0;
        for (int i=3; i<=target; i++) {
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }
}
