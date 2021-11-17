package com.richard.剑指offer;

public class 左旋转字符串 {

    public String LeftRotateString(String str,int n) {

        int num = str.length();
        if (0 == num) {
            return "";
        }
        if (0 == n) {
            return str;
        }
        return str.substring(n%num,num) + str.substring(0,n%num);
    }
}
