package leetcode.editor.cn.wangkun.doublepoint;

public class RemoveElement {

    /**
     * 在数组在原地移除指定的元素
     *
     * 如果新建一个数组，将不一样的复制过去，
     * 但是要是原址操作，那么就只能两个指针来跟踪需要放的位置
     * @param nums
     * @param val
     * @return
     */
    int removeElement(int[] nums, int val){
        int n = nums.length;
        int slow = 0, fast = 0;
        while (fast < n){
            if(nums[fast] != val){
                nums[slow] = nums[fast];
                slow ++;
            }
            fast++;
        }

        return slow + 1;
    }

}
