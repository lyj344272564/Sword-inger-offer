package com.richard.剑指offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class 按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = false;
        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for (int i=0; i<size; i++) {
                TreeNode t = q.poll();
                level.add(t.val);
                if (null != t.left) {
                    q.offer(t.left);
                }
                if (null != t.right) {
                    q.offer(t.right);
                }
            }
            if (flag) {
                Collections.reverse(level);
            }
            flag = !flag;
            res.add(level);
        }
        return res;
    }
}
