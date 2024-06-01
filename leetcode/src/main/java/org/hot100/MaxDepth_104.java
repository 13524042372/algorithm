package org.hot100;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 这个用广度优先算法进行计算就可以
 */
public class MaxDepth_104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while(!queue.isEmpty()){
            depth++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        return depth;
    }
}
