package leetcode.editor.cn.wangkun.doublepoint;

public class CanChange {
    public boolean canChange(String start, String target) {
        int n = target.length();
        int i = 0, j = 0;
        while(i < n && j < n){
            while(i < n & start.charAt(i) == '_'){
                i++;
            }
            while (j < n & target.charAt(j) == '_'){
                j++;
            }
            /**
             * 1 目标不一致
             * 2 一致但是位置不满足左右条件
             *
             */
            if (i < n && j < n) {
                if(start.charAt(i) != target.charAt(j)){
                    return false;
                }
                if((start.charAt(i) == 'L' && i < j)||(start.charAt(j) == 'R' && i > j)){
                   return false;
                }
                i++;
                j++;

            }

        }
        while(i < n){
            if(start.charAt(i) != '_'){
                return false;
            }
        }
        while(j < n){
            if(target.charAt(j) != '_'){
                return false;
            }
        }
        return true;

    }

}
