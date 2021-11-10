package com.richard.剑指offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class 序列化二叉树 {

    String Serialize(TreeNode root) {
        if (null == root) {
            return "#";
        }

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> stack = new LinkedList<>();

        stack.offerLast(root);
        while (!stack.isEmpty()) {
            TreeNode t = stack.pollLast();
            if (null == t) {
                sb.append("#").append(",");
            } else {
                sb.append(t.val).append(",");
                // 因为要取最后一个所以先添加right
                stack.offerLast(t.right);
                stack.offerLast(t.left);
            }
        }
        return sb.toString();
    }

    TreeNode Deserialize(String str) {
        Deque<String> queue = new LinkedList<>(Arrays.asList(str.split(",")));
        return buildTree(queue);
    }

    TreeNode buildTree(Deque<String> queue) {
        String s = queue.poll();
        if ("#".equals(s)) {
            return null;
        }
        int val = Integer.parseInt(s);
        TreeNode root = new TreeNode(val);
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
