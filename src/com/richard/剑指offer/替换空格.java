package com.richard.剑指offer;

public class 替换空格 {

    public String replaceSpace (String s) {

        StringBuilder sb = new StringBuilder();

        char[] chars = s.toCharArray();

        for (int i=0; i<chars.length; i++) {
            if (chars[i]==' ') {
                sb.append("%20");
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
