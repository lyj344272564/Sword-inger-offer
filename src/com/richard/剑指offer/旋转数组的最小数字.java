package com.richard.剑指offer;

public class 旋转数组的最小数字 {

    public int minNumberInRotateArray(int [] array) {
        // 边界
        if (0 == array.length) {
            return -1;
        }
        int n = array.length - 1;
        // 去掉一样的
        while (n>0 && array[n] == array[0]) {
            n--;
        }
        // 判断是否升序
        if (array[n] >= array[0]) {
            return array[0];
        }

        // 二分
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = l + r >> 1;
            if (array[mid] < array[0]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return array[l];
    }
}
