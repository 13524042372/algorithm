package com.labuladuo;


public class RemoveDuplicates {
    int removeDuplicates(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }
       int n = nums.length;
        int slow = 0, fast = 0;
        while(fast < n){
            if(nums[slow] != nums[fast]){
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow + 1;

    }}

