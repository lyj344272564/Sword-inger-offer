package com.richard.剑指offer;

public class 在二叉树中找到两个节点的最近公共祖先 {

    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        return helper(root,o1,o2).val;
    }

    public TreeNode helper(TreeNode root, int o1, int o2) {
        if (null==root || root.val==o1 || root.val==o2) {
            return root;
        }
        TreeNode l = helper(root.left,o1,o2);
        TreeNode r = helper(root.right,o1,o2);
        //如果left为空，说明这两个节点在root结点的右子树上，我们只需要返回右子树查找的结果即可
        if (null == l) {
            return r;
        }
        if (null == r) {
            return l;
        }
        //如果left和right都不为空，说明这两个节点一个在root的左子树上一个在root的右子树上，
        //我们只需要返回cur结点即可。
        return root;
    }
}
