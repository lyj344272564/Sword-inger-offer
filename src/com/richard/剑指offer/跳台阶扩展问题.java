package com.richard.剑指offer;

public class 跳台阶扩展问题 {

    public int jumpFloorII(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * jumpFloorII(target-1);
        }
    }
}
