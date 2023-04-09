package leetcode.editor.cn.wangkun.doublepoint;

public class TwoSum {
    int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum == target){
                return new int[]{left + 1, right + 1};
            } else if(sum < target){
                left++;
            }else {
                right++;
            }
        }
        return new int[]{-1, -1};
    }

}
