package com.richard.剑指offer;

public class 二叉搜索树与双向链表 {

    public TreeNode Convert(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode left = rightMost(root.left);
        TreeNode right = leftMost(root.right);

        Convert(root.left);
        Convert(root.right);

        if (null != left) {
            left.right = root;
        }
        root.left = left;

        if (null != right) {
            right.left = root;
        }
        root.right = right;
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

    // 找到最左面的节点
    TreeNode leftMost(TreeNode root) {
        if (null == root) {
            return null;
        }
        while (null != root.left) {
            root = root.left;
        }
        return root;
    }

    //找到最右面的节点
    TreeNode rightMost(TreeNode root) {
        if (null == root) {
            return null;
        }
        while (null != root.right) {
            root = root.right;
        }
        return root;
    }

}
