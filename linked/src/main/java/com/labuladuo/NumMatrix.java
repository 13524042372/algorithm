package com.labuladuo;

public class NumMatrix {
    private int[][] preSum;

    public NumMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        preSum = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] + preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }

    }

    // 计算子矩阵 [x1, y1, x2, y2] 的元素和
    public int sumRegion(int x1, int y1, int x2, int y2) {
        return preSum[x2 + 1][y2 + 1] - preSum[x1][y2 + 1] - preSum[x2 + 1][y1] + preSum[x1][y1];
    }
}
