package leetcode.editor.cn.wangkun.pivot;

import java.util.Arrays;

public class PivotIndex_724 {
    public int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1){
            return -1;
        }
        int t = 0;
        for(int i = 0; i < nums.length; i++){
            if(t * 2 == (sum - nums[i] )){
                return i;
            }
            t = t + nums[i];

        }
        return -1;
    }
}
