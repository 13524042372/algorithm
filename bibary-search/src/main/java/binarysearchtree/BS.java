package binarysearchtree;

public class BS {
    public int bs(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target){

            }else if (nums[mid] < target){

            }else if (nums[mid] > target){

            }
        }
        return nums[left];
    }
}
