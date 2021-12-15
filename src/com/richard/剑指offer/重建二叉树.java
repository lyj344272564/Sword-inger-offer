package com.richard.剑指offer;

import java.util.HashMap;
import java.util.Map;

public class 重建二叉树 {

    //key是中序遍历的值，value是中序遍历的结果（下标）
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode reConstructBinaryTree(int [] preorder,int [] inorder) {
        //保存中序遍历的信息
        for (int i=0; i<inorder.length; i++) {
            map.put(inorder[i],i);
        }
        return createTree(preorder,0,inorder,0,inorder.length-1);
    }
    //preIndex是前序遍历的索引，inStart和inEnd是中序遍历的索引范围
    TreeNode createTree(int[] preorder,int preIndex,int[] inorder,int inStart,int inEnd) {
        // 判断边界
        if (inStart > inEnd) {
            return null;
        }
        //获取前序遍历的值
        int val = preorder[preIndex];
        //获取前序遍历值在中序遍历的位置
        int inIndex = map.get(val);
        //以该值作为根节点的值创建根节点
        TreeNode root = new TreeNode(val);
        //根节点的左子树节点数目
        int leftNum = inIndex - inStart;
        //根节点以左创建左子树，根节点以右创建右子树
        root.left = createTree(preorder,preIndex+1,inorder,inStart,inIndex-1);
        root.right = createTree(preorder,preIndex+1+leftNum,inorder,inIndex+1,inEnd);

        return root;
    }
}
