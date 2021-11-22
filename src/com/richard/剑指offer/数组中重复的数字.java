package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 数组中重复的数字 {

    public int duplicate (int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i< nums.length; i++) {
            if (list.contains(nums[i])) {
                return nums[i];
            }
            list.add(nums[i]);
        }
        return -1;
    }

    public int duplicate2 (int[] nums) {
        for (int x : nums) {
            if (x<0 || x>nums.length) {
                return -1;
            }
        }
        for (int i=0; i<nums.length; i++) {
            if (i != nums[i]) {
                int cur = nums[i];
                    if (cur == nums[cur]) {
                        return cur;
                    } else {
                        nums[i] = nums[cur];
                        nums[cur] = cur;
                    }
                }
            }
        return -1;
    }

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }

    // 原地置换
    public int findRepeatNumber2(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }


}
