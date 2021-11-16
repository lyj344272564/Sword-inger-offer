package com.richard.剑指offer;

import java.util.ArrayList;

public class 顺时针打印矩阵 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null==matrix || 0==matrix.length || 0==matrix[0].length) {
            return res;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = cols - 1;
        int top = 0;
        int bottom = rows - 1;

        while (left<=right && top<=bottom) {
            for (int i=left; i<=right; i++) {
                res.add(matrix[top][i]);
            }
            for (int i=top+1; i<=bottom; i++) {
                res.add(matrix[i][right]);
            }
            if (left<right && top<bottom) {
                for (int i=right-1; i>=left; i--) {
                    res.add(matrix[bottom][i]);
                }
                for (int i=bottom-1; i>top; i--) {
                    res.add(matrix[i][left]);
                }
            }

            left++;
            right--;
            top++;
            bottom--;
        }
        return res;
    }
}
