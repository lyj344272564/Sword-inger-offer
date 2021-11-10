package com.richard.剑指offer;

public class 二叉树的下一个结点 {

    public TreeLinkNode GetNext(TreeLinkNode p) {
        // 有右儿子 则有儿子的最左儿子就是下一个
        if (null != p.right) {
            p = p.right;
            while (null != p.left) {
                p = p.left;
            }
            return p;
        }
        // 若没有右儿子 则判断这个点是不是父节点的右节点是的话那就一直往上找知道找到第一个不是右  则返回他的父节点
        while (null!=p.next && p==p.next.right) {
            p = p.next;
        }
        return p.next;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    public TreeLinkNode(int val) {
        this.val = val;
    }
}
