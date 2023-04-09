package leetcode.editor.cn.wangkun.doublepoint;

public class ReverseString {
    void reverseString(char[] s) {
        if(s.length == 0){
            return;
        }
        int left = 0, right = s.length - 1;
        while (left < right){
            char cl = s[left];
            s[left] = s[right];
            s[right] = cl;
            left++;
            right++;
        }
    }

}
