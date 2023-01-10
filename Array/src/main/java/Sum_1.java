import java.util.HashMap;
import java.util.Map;

public class Sum_1 {

    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }

        return nums;
    }
}
