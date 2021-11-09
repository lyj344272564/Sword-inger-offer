package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 从上往下打印二叉树 {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> res = new ArrayList<>();

        if (null == root) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode t = q.poll();
            res.add(t.val);
            if (null != t.left) {
                q.offer(t.left);
            }
            if (null != t.right) {
                q.offer(t.right);
            }
        }

        return res;

    }
}
