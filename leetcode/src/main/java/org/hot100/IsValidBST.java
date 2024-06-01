package org.hot100;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root.left,Long.MIN_VALUE, root.val) && isValidBST(root.right, root.val, Long.MAX_VALUE);

    }

    private boolean isValidBST(TreeNode root, long min , long max){
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBST(root.left,min, root.val) && isValidBST(root.right, root.val, max);
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
