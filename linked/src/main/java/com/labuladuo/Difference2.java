package com.labuladuo;

import java.util.Arrays;

public class Difference2 {
    int[] d ;

    public Difference2(int[] nums){
        d = new int[nums.length];
        d[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            d[i] = nums[i] - nums[i - 1];
        }
    }

    public void increament(int l, int r, int val){
        d[l] += val;
        d[r + 1] -= val;
    }

    public int[] result(){
        int[] result = new int[d.length];
        result[0] = d[0];
        for(int i = 1; i < result.length; i++){
            result[i] = d[i] + result[i - 1];
        }
        return result;
    }

    public static void main(String[] args) {
        Difference2 d = new Difference2(new int[]{1,2,3,4,5,6,7,8,9});
        d.increament(2,3, 2);
        System.out.println(Arrays.toString(d.result()));
    }
}
