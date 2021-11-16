package com.richard.剑指offer;

public class 构建乘积数组 {

    public int[] multiply(int[] a) {
        int[] b = new int[a.length];
        for (int i=0,n=1; i<a.length; i++) {
            b[i] = n;
            n *= a[i];
        }

        for (int i=b.length-1,n=1; i>=0; i--) {
            b[i] *= n;
            n *= a[i];
        }
        return b;
    }
}
