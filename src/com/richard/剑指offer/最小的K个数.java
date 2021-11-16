package com.richard.剑指offer;

import java.util.ArrayList;

public class 最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<>();

        quick_sort(nums,0,nums.length-1);
        for (int i=0; i<k; i++) {
            res.add(nums[i]);
        }

        return res;
    }

    public void quick_sort(int[] q, int l, int r) {
        if (l >= r) {
            return ;
        }

        int x = q[l];
        int i = l - 1;
        int j = r + 1;

        while (i < j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j]>x);
            if (i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q,l,j);
        quick_sort(q,j+1,r);
    }
}
