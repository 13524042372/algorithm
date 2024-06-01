package com.labuladong;

public class MinimumFallingPathSum_931 {
    /**
     * 动态规划算法
     * 初始值：
     *  matrix[0]
     * dp方程：
     *  dp[i][j] = Math.min(dp[i - 1][j - 1],dp[i - 1][j],dp[i - 2][j + 1]) + + matrix[i][j]
     * @param matrix
     * @return
     */
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        //设置初始值
        for(int i = 0; i < n; i++){
            dp[0][i] = matrix[0][i];
        }
        //开始遍历计算
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i - 1][j],dp[i - 1][j + 1]) + matrix[i][j];
                    continue;
                }
                if(j == n - 1){
                    dp[i][j] = Math.min(dp[i - 1][j - 1],dp[i - 1][j]) + matrix[i][j];
                    continue;
                }
                dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1],dp[i - 1][j]),dp[i - 1][j + 1]) + matrix[i][j];
            }
        }
        int ans  = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
           ans = Math.min(ans,dp[m - 1][i]);
        }
        return ans;
    }
}
