package org.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merge = new ArrayList<>();
        for(int i = 0; i < intervals.length; i++){
            int L = intervals[i][0],  R = intervals[i][1];
            if( merge.size() == 0 || merge.get(merge.size() - 1)[1] < L ){
                merge.add(new int[]{L,R});
            } else {
                merge.get(merge.size() - 1)[1]  = Math.max(R,merge.get(merge.size() - 1)[1]);
            }
        }

        return merge.toArray(new int[merge.size()][]);
    }
}
