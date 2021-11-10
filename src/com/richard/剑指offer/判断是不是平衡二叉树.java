package com.richard.剑指offer;

public class 判断是不是平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (null == root) {
            return true;
        }

        int lh = dfs(root.left);
        int rh = dfs(root.right);

        return Math.abs(lh-rh)<=1 && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);

    }

    public int dfs(TreeNode root) {
        if (null == root) {
            return 0;
        }
        return Math.max(dfs(root.left),dfs(root.right)) + 1;
    }
}
