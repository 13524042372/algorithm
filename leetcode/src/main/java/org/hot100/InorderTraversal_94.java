package org.hot100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InorderTraversal_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList();
        while(root != null || !queue.isEmpty()){
            while(root.left != null){
                queue.offer(root);
                root = root.left;
            }
            root = queue.poll();
            ans.add(root.val);
            root = root.right;

        }
        return ans;
    }
}
