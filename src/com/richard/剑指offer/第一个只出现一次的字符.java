package com.richard.剑指offer;

import java.util.Collections;
import java.util.HashMap;

public class 第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c,2);
            } else {
                map.put(c,1);
            }
        }
        int idx = 0;
        for (char c : str.toCharArray()) {
            if (1 == map.get(c)) {
                return idx;
            }
            idx++;
        }
        return -1;

    }
}
