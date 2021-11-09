package com.richard.剑指offer;

import java.util.*;

public class 二叉搜索树的第k个结点 {

    TreeNode KthNode(TreeNode root, int k) {
        List<Integer> res = new ArrayList<>();

        if (null == root || k < 1) {
            return null;
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

        if (res.size() < k) {
            return null;
        }
        Collections.sort(res);


        return new TreeNode(res.get(k-1));
    }

}
