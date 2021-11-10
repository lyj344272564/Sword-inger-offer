package com.richard.剑指offer;

public class 二叉树中和为某一值的路径三 {

    public int key = 0;

    public int FindPath (TreeNode root, int sum) {
        // write code here
        if (null == root) {
            return key;
        }
        dfs(root,sum);
        FindPath(root.left,sum);
        FindPath(root.right,sum);

        return key;
    }

    public void dfs(TreeNode root, int sum) {
        if (null == root) {
            return;
        }
        sum -= root.val;
        if (0 == sum) {
            key++;
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
    }
}
