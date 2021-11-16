package com.richard.剑指offer;

import java.util.LinkedList;
import java.util.Queue;

public class 机器人的运动范围 {

    // 一个标志  判断是否遍历过
    boolean[][] st = new boolean[105][105];

    int getSumGG(int x) {
        int sum = 0;
        while (x>0) {
            sum += x%10;
            x /= 10;
        }
        return sum;
    }

    int getSum(int x, int y) {
        return getSumGG(x) + getSumGG(y);
    }

    public int movingCount(int threshold, int rows, int cols) {

        int res = 0;

        if (rows == 0 || cols == 0) {
            return 0;
        }
        Queue<Cord> q = new LinkedList<>();
        q.add(new Cord(0,0));
        st[0][0] = true;

        while (!q.isEmpty()) {
            Cord cc = q.poll();
            // 首先 判断是否  满足题意
            if (getSum(cc.x,cc.y) > threshold || st[cc.x][cc.y]==false) {
                continue;
            }
            res++;

            // 向量遍历四个方向
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};
            for (int i=0; i<4; i++) {
                int xx = cc.x + dx[i];
                int yy = cc.y + dy[i];
                if (xx>=0 && xx<rows && yy>=0 && yy<cols && st[xx][yy]==false && getSum(xx,yy)<=threshold) {
                    q.add(new Cord(xx,yy));
                    st[xx][yy] = true;
                }
            }
        }
        return res;
    }
}
class Cord {
    public int x;
    public int y;

    public Cord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
