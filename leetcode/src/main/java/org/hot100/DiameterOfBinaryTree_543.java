package org.hot100;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DiameterOfBinaryTree_543 {
    /**
     *这个算法不对，问题在于，可能通过的路线不经过root节点
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        return depth(root.left) + depth(root.right);
    }

    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        int depth =  0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while(!queue.isEmpty()){
            ++depth;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                TreeNode poll = queue.poll();
                if(poll.left != null){
                    queue.offer(poll.left);
                }
                if(poll.right != null){
                    queue.offer(poll.right);
                }
            }
        }
        System.out.println(depth);
        return depth;
    }

    int ans = 0;

    public int diameterOfBinaryTree2(TreeNode root) {
        return depth2(root) - 1;
    }

    private int depth2(TreeNode node){
        if(node == null){
            return 0;
        }
       int l =  depth2(node.left);
        int r = depth2(node.right);
        ans = Math.max(ans,l +r +1);
        return Math.max(l,r) + 1;
    }
}
