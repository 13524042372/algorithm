package leetcode.editor.cn.wangkun.doublepoint;

public class RemoveDuplicates {

    int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(nums.length == 0){
            return 0;
        }
        int slow = 0, fast = 0;
        while (fast < n){
            if (nums[fast] != nums[slow] ){
                slow ++;
                nums[slow] = nums[fast];
            }
            fast++;
        }

        return slow + 1;
    }
}

