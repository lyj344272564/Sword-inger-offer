package com.richard.剑指offer;

public class 跳台阶 {

    public int jumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        return jumpFloor(target-1) + jumpFloor(target-2);
    }
}
