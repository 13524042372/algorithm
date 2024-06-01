package org.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(Arrays.toString(intervals[1]));
        }
        System.out.println(Arrays.toString(intervals));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] ints = intervals[i];
            if(list.get(list.size() - 1)[1] >= ints[0]){
                list.get(list.size() - 1)[1] = ints[1];
            }else {
                list.add(ints);
            }

        }
        return list.toArray(new int[0][]);
    }
}
