package com.labuladuo;

public class NumArray2 {
    int[] p;
    public NumArray2(int[] nums){
        p = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++){
            p[i] = p[i - 1] + nums[i - 1];
        }
    }
    public int numArray(int[] nums, int left, int right){
        return p[right + 1] - p[left];
    }
}
