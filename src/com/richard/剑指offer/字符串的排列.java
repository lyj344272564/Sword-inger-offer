package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.HashSet;

// 通过交换c中字符的位置来实现
public class 字符串的排列 {

    ArrayList<String> res  = new ArrayList<>();
    char[] c;

    public ArrayList<String> Permutation(String str) {
        c = str.toCharArray();
        dfs(0);
        return res;
    }

    public void dfs(int x) {
        if (x == c.length-1) {
            res.add(String.valueOf(c));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for (int i=x; i<c.length; i++) {
            if (set.contains(c[i])) {
                continue;
            }
            set.add(c[i]);
            swap(i,x);
            dfs(x+1);
            swap(i,x);
        }
    }

    public void swap(int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

}
