package com.richard.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 最长不含重复字符的子字符串 {

    public int lengthOfLongestSubstring (String s) {
        int len = 0;
        Map<Character,Integer> map = new HashMap<>();
        // j之前最长不重复子字符串
        for (int i=0,j=0; j<s.length(); j++) {
            char c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c)+1);
            }
            len = Math.max(len,j-i+1);
            map.put(c,j);
        }
        return len;
    }
}
