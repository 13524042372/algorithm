package org.hot100;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum_560 {

    /**
     * 题目： 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数
     *
     * 用一个数组代表之前的和，在之间的数据之和便是后面的减掉前面的，
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + nums[i];
            if(map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return ans;
    }
}
