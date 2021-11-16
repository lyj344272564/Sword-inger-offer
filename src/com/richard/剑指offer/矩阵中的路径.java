package com.richard.剑指offer;

public class 矩阵中的路径 {

    public boolean hasPath (char[][] matrix, String str) {
        // write code here
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (dfs(matrix,str,0,i,j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] matrix, String str, int u, int x, int y) {
        if (x<0 || x>matrix.length || y<0 || y>matrix[0].length || str.charAt(u) != matrix[x][y]) {
            return false;
        }
        if (u == str.length()-1) {
            return true;
        }

        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};

        char t = matrix[x][y];
        matrix[x][y] = '*';
        for (int i=0; i<4; i++) {
            int a = x + dx[i];
            int b = y + dy[i];
            if (a>=0 && a<matrix.length && b>=0 && b<matrix[0].length) {
                if (dfs(matrix,str,u+1,a,b)) {
                    return true;
                }
            }
        }
        matrix[x][y] = t;
        return false;
    }
}