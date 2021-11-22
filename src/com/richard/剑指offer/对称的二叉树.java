package com.richard.剑指offer;

public class 对称的二叉树 {

    boolean isSymmetrical(TreeNode root) {
        if (null == root) {
            return true;
        }
        return dfs(root.left,root.right);
    }

    public boolean dfs(TreeNode l, TreeNode r) {
        if (null==l || null==r) {
            return null==l&&null==r;
        }
        if (l.val != r.val) {
            return false;
        }
        return dfs(l.left,r.right) && dfs(l.right,r.left);
    }
}
