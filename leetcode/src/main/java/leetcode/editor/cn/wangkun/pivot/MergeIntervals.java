package leetcode.editor.cn.wangkun.pivot;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> ans = new ArrayList<>();
        //System.out.println(Arrays.toString());
        int[] t = new int[]{intervals[0][0],intervals[0][1]};
        for (int i = 1; i < intervals.length;i++){
            if(t[1] <= intervals[i][0]){
                t[1] = intervals[i][1];
            }else {
                ans.add(new int[]{t[0],t[1]});
                t = new int[]{intervals[i][0],intervals[i][1]};
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        //int[] t = new int[]{1,3};
        char a = 'a';
        char b = 'a';
        System.out.println(a == b);

    }
}
