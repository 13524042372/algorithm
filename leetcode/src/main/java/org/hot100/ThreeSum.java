package org.hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int first = 0; first < n - 2; first++){
            //跳过和之前一样的
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }

            int target = -nums[first];
            int third = n - 1;
            for(int second = first + 1;second < n - 1; second++){
                if(second > first + 1 && nums[second] == nums[second - 1]){
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target){
                    third--;
                }
                if(second == third){
                    break;
                }
                if(nums[second] + nums[third] == target){
                    List<Integer> re = new ArrayList<>();
                    re.add(nums[first]);
                    re.add(nums[second]);
                    re.add(nums[third]);
                    ans.add(re);
                }


            }
        }
        return ans;
    }
}
