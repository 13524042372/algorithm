package com.labuladuo;

/**
 * 二维数组的区间和
 */
public class SumArrays {
    int[][] p ;
    public SumArrays(int[][] arrays){
        int m =  arrays.length;
        int n = arrays.length;
        p = new int[m + 1][n + 1];
        for(int i = 1; i < m + 1; i++){
            for (int j = 1; j < n + 1; j++){
                p[i][j] = arrays[i - 1][j - 1] + p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1];
            }
        }
    }
    public int sum(int r1, int c1, int r2,int c2){
        return p[r2][c2] - p[r1][c2] - p[r2][c1] + p[r1][c1];
    }

}
