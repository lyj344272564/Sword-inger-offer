package com.richard.剑指offer;

public class 二维数组中的查找 {

    public boolean Find(int target, int [][] array) {
        int n = array.length;
        int m = array[0].length;

        int i = 0;
        int j = m - 1;
        while (i<n && j>=0) {
            if (array[i][j] == target) {
                return true;
            } else if (array[i][j] < target){
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}