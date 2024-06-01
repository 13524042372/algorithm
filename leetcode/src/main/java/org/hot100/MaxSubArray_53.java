package org.hot100;

public class MaxSubArray_53 {
    /**
     * 动态规划：
     * dp[] 以i为结尾的子数组和的最大值
     *  base条件：
     *
     *  转移方程：
     *      f（n） = max（DP[i - 1] + nums[i], nums[i]）
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for (int x: nums) {
            pre = Math.max(pre + x, x);
            max = Math.max(pre, max);

        }
        return max;
    }
}
