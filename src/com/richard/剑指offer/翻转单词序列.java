package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 翻转单词序列 {

    public String ReverseSentence(String str) {
        String[] s = str.split(" ");
        List<String> list = new ArrayList<>();

        for (int i=0; i<s.length; i++) {
            list.add(s[i]);
        }

        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();

        for (int i=0; i<list.size(); i++) {
            if (i < list.size()-1) {
                sb.append(list.get(i) + " ");
            } else {
                sb.append(list.get(i));
            }
        }

        return sb.toString();
    }
}
