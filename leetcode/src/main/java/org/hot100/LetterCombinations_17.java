package org.hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations_17 {

    private Map<Integer,String> map = new HashMap(){{
        put(0," ");
        put(1,"");
        put(2,"abc");
        put(3,"def");
        put(4,"ghi");
        put(5,"jkf");
        put(6,"mno");
        put(7,"pqrs");
        put(8,"tuv");
        put(9,"wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        char[] c = new char[digits.length()];
        int index = 0;
        List<String> ans = new ArrayList<>();

        letterCombinations(digits, index,c,ans);
        return ans;
    }

    private void letterCombinations(String digits,int index, char[] c, List<String> ans){
        int length = digits.length();
        if(index == length){
            ans.add(new String(c));
            return;
        }
        char c1 = digits.charAt(index);
        String s1 = String.valueOf(c1);
        int digit = Integer.parseInt(s1);

        String s = map.get(digit);
        for(int i = 0; i < s.length(); i++){
            c[index] = s.charAt(i);
            letterCombinations(digits, index + 1, c,ans);
        }

    }

    public static void main(String[] args) {
        LetterCombinations_17 letterCombinations17 = new LetterCombinations_17();
        List<String> strings = letterCombinations17.letterCombinations("23");
        System.out.println(strings);

    }

}
