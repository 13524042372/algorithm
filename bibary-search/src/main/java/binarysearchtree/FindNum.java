package binarysearchtree;

public class FindNum {
    int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        /**
         * [left,right]区间是左闭右闭，两边有效，所以当等号的时候是有效的。
         */
        while(left <= right) {
            int mid = left + (right - left) / 2;//取中间值
            if(nums[mid] == target)//中间值符合要求，直接返回
                return mid;
            else if (nums[mid] < target)//中间值比需要的小，那么去右边区间找
                left = mid + 1; // 注意
            else if (nums[mid] > target)//中间值比需要的大，那么去左边区间找
                right = mid - 1; // 注意
        }
        return -1;
    }

    int binarySearch_1(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }
    public static void main(String[] args) {
        
    }

}
