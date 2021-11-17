package com.richard.剑指offer;

public class 打印从1到最大的n位数 {

    public int[] printNumbers (int n) {
        // write code here
       int res = 0;
       while (n!=0) {
           res = res * 10 + 9;
           n--;
       }
       int[] arr = new int[res];
       for (int i=0; i<arr.length; i++) {
           arr[i] = i+1;
       }
       return arr;
    }
}
