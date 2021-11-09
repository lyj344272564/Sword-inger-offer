package com.richard.剑指offer;

public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int l = TreeDepth(root.left);
        int r = TreeDepth(root.right);
        return Math.max(l,r) + 1;
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
