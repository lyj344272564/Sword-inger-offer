package com.richard.剑指offer;

// 二进制每位相加就像等于异或操作 ^
// 取进位则是a&b<<1
public class 不用加减乘除做加法 {

    public int Add(int a,int b) {
       while (b != 0) {
           int temp = a ^ b;
           b = (a&b)<<1;
           a = temp;
       }
       return a;
    }
}
