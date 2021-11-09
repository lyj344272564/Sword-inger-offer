package com.richard.剑指offer;

public class 二叉树中和为某一值的路径一 {
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (null == root) {
            return false;
        }
        // 深度优先遍历
        return dfs(root,sum);
    }

    public boolean dfs(TreeNode root, int target) {
        // 目标路径不存在，开始回溯
        if (null == root) {
            return false;
        }
        // 更新目标值
        target -= root.val;
        // 当当前节点为叶子节点并且目标路径存在时，返回 true
        if (null==root.left && null==root.right && 0==target) {
            return true;
        }
        // 对左右分支进行 dfs
        return dfs(root.left,target) || dfs(root.right,target);
    }
}
