import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        int[] t = new int[]{1,2,4,3,6};
        t = quictSort(t,0,t.length - 1);
        System.out.println(Arrays.toString(t));
    }

    static  int[] quictSort(int[] nums ,int a,int b){
        if(a == b){
            return nums;
        }
        int x = nums[a];
        int  l = a - 1;
        int  r = b + 1;
         while(l < r){
             do{
                 l++;
             }while(nums[l] < x);
             do{
                 r--;
             }while(nums[r] > x);
             swap(nums,l,r);
         }
         quictSort(nums,a,l);
         quictSort(nums,l + 1,b);
        return nums;
    }
    static  void swap(int[] nums, int a, int b){
        int t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
 }
