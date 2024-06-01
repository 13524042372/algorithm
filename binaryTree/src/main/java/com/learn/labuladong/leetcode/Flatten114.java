package com.learn.labuladong.leetcode;

import dataStructure.TreeNode;

public class Flatten114 {
    public void flatten(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode left = root.left;
        TreeNode right =
        flatten(root.left);
        flatten(root.right);
    }
}
