package org.jike;

/**
 * 动态规划：
 *  Fn  max
 *      1 Fn-2 + nums[n]
 *      2 Fn-1
 *      2023年0110
 */
public class HouseRobber {

    public int rob (int[] nums){
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int pp = nums[0];
        int pre = nums[1];
        int ans = 0;
        for(int i = 0; i < n; i++){
            ans = Math.max(pp + nums[i], pre);
            pp = pre;
            pre = ans;
        }

        return ans;
    }
}
