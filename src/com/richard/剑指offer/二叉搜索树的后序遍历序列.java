package com.richard.剑指offer;

public class 二叉搜索树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (0 == sequence.length) {
            return false;
        }
        return verify(sequence,0,sequence.length-1);
    }

    public boolean verify(int[] sequence,int i, int j) {
        if (i >= j) {
            return true;
        }
        int mid = i;
        //左-右-根，因此mid相当于找到了第一个右节点
        //例如1，3，2，6，9，7，5，root从1开始遍历到6停止，mid=6,132就是左子树
        while (sequence[mid] < sequence[j]) {
            mid++;
        }
        int root = mid;
        //左-右-根，由于已经开始遍历右子树，如果找到第一个不大于j的值只能是j本身
        //例如1，3，2，6，9，7，5，root从6开始遍历到5停止，root=j
        while (sequence[root] > sequence[j]) {
            root++;
        }
        //例如1，3，2，6，9，2，5，root从6开始遍历到2停止，root!=j,5的右子树有2，肯定不对
        if (root != j) {
            return false;
        }
        return verify(sequence,i,mid-1) && verify(sequence,mid,j-1);
    }

}
