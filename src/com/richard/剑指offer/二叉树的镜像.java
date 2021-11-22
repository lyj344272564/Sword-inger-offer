package com.richard.剑指offer;

import java.util.Stack;

public class 二叉树的镜像 {

//    public TreeNode Mirror (TreeNode root) {
//        if (null == root) {
//            return null;
//        }
//
//        Mirror(root.left);
//        Mirror(root.right);
//
//        TreeNode temp = root.right;
//        root.right = root.left;
//        root.left = temp;
//        return root;
//    }

    public TreeNode Mirror (TreeNode root) {
        if (null == root) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pop();
            // 判断最下面一层是否需要加到 栈中
            if (null != t.left) {
                stack.push(t.left);
            }
            if (null != t.right) {
                stack.push(t.right);
            }
            TreeNode temp = t.right;
            t.right = t.left;
            t.left = temp;
        }

        return root;
    }

}
