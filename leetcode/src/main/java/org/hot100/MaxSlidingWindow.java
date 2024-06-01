package org.hot100;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        int[] ans = new int[len - k + 1];
        for(int i = 0; i < k - 1; i++){
            priorityQueue.add(new int[]{nums[i],i});
        }
        for(int i = 0; i < len; i++){
            priorityQueue.add(new int[]{nums[i + k],i + k});


        }
        return ans;
    }
}
