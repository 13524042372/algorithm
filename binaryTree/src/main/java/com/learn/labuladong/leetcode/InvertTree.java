package com.learn.labuladong.leetcode;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 */
public class InvertTree {
    /**
     * 解法1 遍历

     */
    TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode t = root.left;
        root.left = root.right;
        root.right = t;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 分解为子问题递归解决
     * @param root
     * @return
     */
    TreeNode invertTree_2(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = invertTree_2(root.left);
        TreeNode right = invertTree_2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /**
     * 解法3 ：
     * 迭代
     */
    TreeNode invertTree_3(TreeNode root) {
        if (root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode poll = queue.poll();
            TreeNode t = poll.left;
            poll.left = poll.right;
            poll.right = t;
            if(poll.left != null){
                queue.offer(poll.left);
            }
            if(poll.right != null){
                queue.offer(poll.right);
            }
        }
        return root;
    }

    }
