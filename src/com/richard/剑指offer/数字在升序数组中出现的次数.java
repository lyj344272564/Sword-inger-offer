package com.richard.剑指offer;

public class 数字在升序数组中出现的次数 {

    public int GetNumberOfK(int [] array , int k) {
        if (0 == array.length) {
            return 0;
        }
        int[] res = new int[2];
        int l = 0;
        int r = array.length - 1;

        while (l<r) {
            int mid = l + r >> 1;
            if (array[mid] >= k) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (array[l] != k) {
            return 0;
        }
        int L = l;
        l = 0;
        r = array.length - 1;
        while (l<r) {
            int mid = l + r + 1 >> 1;
            if (array[mid] <= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return r-L+1;
    }
}
