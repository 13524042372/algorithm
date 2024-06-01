package org.hot100;

import java.util.*;

public class MergeIntervals_1 {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ans.add(new int[]{intervals[0][0],intervals[0][1]});
        for (int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < ans.get(ans.size() - 1)[1]){
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1],intervals[i][1]);
            } else {
               ans.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        return ans.toArray(new int[0][]);
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int sum = m + n - 2;
        int[] ans = new int[m * n];
        int index = 0;
        for (int s = 0; s < sum; s++){
            if(s % 2 == 0){
                for(int i = s, j= 0; i > 0; i--,j++){
                }
            }else {
                for(int i = 0, j = s; j > 0; i++,j--){
                    ans[index++] = mat[i][j];
                }
            }
        }
        return ans;
    }


}
