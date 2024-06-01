package com.learn.labuladong;


import dataStructure.TreeNode;

public class TreeTraversal {

    public void traversal(TreeNode treeNode){
        if(treeNode == null){
            return;
        }
        //前序遍历位置
        traversal(treeNode.left);
        //中序遍历
        traversal(treeNode.right);
        //后续遍历位置
    }



}
