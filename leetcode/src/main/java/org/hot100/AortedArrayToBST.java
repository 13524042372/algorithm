package org.hot100;

public class AortedArrayToBST {
    /**
     * 1 已经排序好的，那么中间位置的就是父节点
     * 依次递归计算就行
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums,0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int a, int b){
        if(a > b){
            return null;
        }
        if(a == b){
            return new TreeNode(nums[a]);
        }
        int mid = (a + b)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,a,mid - 1);
        root.right = sortedArrayToBST(nums,mid + 1,b);
        return root;
    }
}
