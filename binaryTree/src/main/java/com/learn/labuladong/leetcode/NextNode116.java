package com.learn.labuladong.leetcode;

import dataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class NextNode116 {
    public void nextNode(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode pre = null;
            for (int i = 0; i < size; i++){
                TreeNode t = queue.poll();
                if(pre == null){
                    pre = t;
                } else {
                    pre.next = t;
                }
                if(t.left != null){
                    queue.offer(t.left);
                }
                if(t.right != null){
                    queue.offer(t.right);
                }
            }
        }
    }
}
