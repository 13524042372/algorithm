package leetcode.editor.cn.wangkun.pivot;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.Arrays;

public class Rotate {
    public void rotate(int[][] matrix) {
        //先对角翻转，然后进行水平翻转
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m - 1; m++){
            for (int j = 0; j + i < m && j < n; j++){
                int t = matrix[i][j];
                matrix[i][j] = matrix[m - i][n - j];
                matrix[m - i][n - j] = t;
            }
        }

        for(int i = 0; i <= m / 2; i++){
            for(int j = 0;j < n; j++){
               int t =  matrix[i][j];
                matrix[i][j] = matrix[m - i][n - j];
                matrix[m - i][n - j] = t;
            }
        }
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i * i <= n; i++){
            dp[i * i] = 1;
        }
        for(int i = 2; i <= n && dp[i] != 1 ; i++ ){
            for(int j = 1; j <= i; j++){
                dp[i] = Math.min(dp[i],dp[j] + dp[i - j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
        rotate.numSquares(5);
    }
}
