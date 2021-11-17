package com.richard.剑指offer;

import java.util.Arrays;

public class 把数组排成最小的数 {

    public String PrintMinNumber(int[] nums) {
        //先将int数组转为String数组
        String[] strs = new String[nums.length];
        for (int i=0; i<nums.length; i++) {
            strs[i]= String.valueOf(nums[i]);
        }

        //对String数组排序
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }
}
