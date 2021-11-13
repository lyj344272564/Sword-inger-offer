package com.richard.剑指offer;

public class 礼物的最大价值 {

    public int maxValue (int[][] grid) {
        // write code here

        int n = grid.length;
        int m = grid[0].length;

        int[][] f = new int[n+1][m+1];

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=m; j++) {
                f[i][j] = Math.max(f[i-1][j],f[i][j-1]) + grid[i-1][j-1];
            }
        }

        return f[n][m];
    }
}
