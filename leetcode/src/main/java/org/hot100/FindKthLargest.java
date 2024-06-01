package org.hot100;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for( int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        int ans = 0;
        for(int i = 0; i < k; i++){
            ans =   pq.poll();
        }
        return ans;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for(Map.Entry<Integer,Integer> e :map.entrySet()){
            Integer key = e.getKey();
            Integer value = e.getValue();
            pq.add(new int[]{key, value});
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i++){
           ans[i] =  pq.poll()[0];
        }
        return  ans;
    }
}
