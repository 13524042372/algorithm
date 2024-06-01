package leetcode.editor.cn.wangkun;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        FindDuplicate fin = new FindDuplicate();
        int[] d = new int[]{0,1,2,3,4,5,5};
        System.out.println(fin.findDuplicate(d));
    }
}
