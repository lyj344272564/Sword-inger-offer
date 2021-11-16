package com.richard.剑指offer;

public class 数值的整数次方 {

    public double Power(double x, int n) {

        if (0 == n) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        double res = Power(x,n/2);
        // 偶数不可能为负数
        if (n%2 == 0) {
            return res*res;
        }
        // 如果n小于0那么次方与正的成倒数
        return n<0?res*res*1/x:res*res*x;
    }
}
