package com.richard.剑指offer;

public class 斐波那契数列 {

    public int Fibonacci(int n) {
        int a = 1;
        int b = 1;

        for (int i=2; i<=n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return a;
    }
}
