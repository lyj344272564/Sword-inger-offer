package com.richard.剑指offer;

public class 孩子们的游戏圆圈中最后剩下的数 {

    // 递归
    public int LastRemaining_Solution(int n, int m) {
        if (0 == n) {
            return 0;
        }
        return (LastRemaining_Solution(n-1,m)+m) % n;
    }

    // 数组模拟
    public int LastRemaining_Solution1(int n, int m) {
        int res = 0;
        for (int i=2; i<=n; i++) {
            res = (res+m) % i;
        }
        return res;
    }
}
