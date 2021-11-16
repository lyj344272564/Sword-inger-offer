package com.richard.剑指offer;

public class 求1到n的和 {

    public int Sum_Solution(int n) {
        boolean b = (n>1) && (n+=Sum_Solution(n-1))==0;
        return n;
    }
}
