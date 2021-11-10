package com.richard.剑指offer;

import java.util.ArrayList;

public class 二叉树中和为某一值的路径二 {

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int sum) {
        help(root,sum);
        return res;
    }

    public void help(TreeNode root, int sum) {
        if (null == root) {
            return ;
        }
        temp.add(root.val);
        // 只有在路径末尾是叶子节点时才添加结果
        if (sum==root.val && null==root.left && null==root.right) {
            res.add(new ArrayList<>(temp));
        }
        help(root.left,sum-root.val);
        help(root.right,sum-root.val);
        temp.remove(temp.size()-1);
    }
}
