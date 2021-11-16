package com.richard.剑指offer;

public class 数组中的逆序对 {
    int[] temp ;

    public int InversePairs(int[] nums) {

        temp = new int[nums.length];

        return  merge_sort(nums,0,nums.length-1);

    }

    public int merge_sort(int[] nums, int l, int r) {
        if (l>=r) {
            return 0;
        }
        int mid = l + r >> 1;
        int res = merge_sort(nums,l,mid) + merge_sort(nums,mid+1,r);

        int i = l;
        int j = mid + 1;
        int k = 0;
        while (i<=mid && j<=r) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
                res += mid-i+1;
                res %= 1000000007;
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= r) {
            temp[k++] = nums[j++];
        }

        for (i=l,j=0; i<=r; i++,j++) {
            nums[i] = temp[j];
        }

        return res;

    }
}
