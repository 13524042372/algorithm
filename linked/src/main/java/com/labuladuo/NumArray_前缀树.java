package com.labuladuo;

public class NumArray_前缀树 {
    int[] pre = null;

    public NumArray_前缀树(int[] nums) {
        pre = new int[nums.length + 1];
        for(int i = 1; i < nums.length + 1; i++){
            pre[i] = pre[i - 1] + nums[i - 1];
        }

    }

    /* 查询闭区间 [left, right] 的累加和 */
    public int sumRange(int left, int right) {
        return pre[right + 1] - pre[left];
    }






}
