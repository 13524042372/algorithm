package org.hot100;

/**
 * 给你一个满足下述两条属性的 m x n 整数矩阵：
 *
 * 每行中的整数从左到右按非递减顺序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 给你一个整数 target ，如果 target 在矩阵中，返回 true ；否则，返回 false 。
 */
public class SearchMatrix_74 {

    /**
     * 用两次二分查找就行
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        //查找所在的行
        int left = 0 , right = matrix.length - 1;
        int n = 0;
        while(left <= right){
            int mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else if (matrix[mid][0] < target) {
                n = mid;
                left = left + 1;
            } else {
                return true;
            }
        }

        System.out.println();
        left = 0;
        right = matrix[0].length;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(matrix[n][mid] > target){
                right = mid - 1;
            }else if (matrix[n][mid] < target){
                left = left + 1;
            }else {
                return true;
            }
        }
        return false;

    }
}
