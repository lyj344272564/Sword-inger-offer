package com.richard.剑指offer;

public class 树的子结构 {

    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if (null == root1 || null == root2) {
            return false;
        }
        //以当前节点为根匹配，或者以左右节点为根匹配
        return isSub(root1,root2) || HasSubtree(root1.left,root2) || HasSubtree(root1.right,root2);
    }

    public boolean isSub(TreeNode A, TreeNode B) {
        //B为空代表匹配完毕
        if (null == B) {
            return true;
        }
        //B非空但A空，匹配失败
        if (null == A) {
            return false;
        }
        //两个节点值不同，匹配失败
        if (A.val != B.val) {
            return false;
        }
        //根节点相同，匹配左右节点
        return isSub(A.left,B.left) && isSub(A.right,B.right);
    }
}
