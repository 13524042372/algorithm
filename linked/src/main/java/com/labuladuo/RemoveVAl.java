package com.labuladuo;

public class RemoveVAl {

    int removeElement(int[] nums, int val){
        int slow = -1, fast = 0;
        while (fast < nums.length){
            if(nums[fast] != val){
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
