package lc;

import java.util.ArrayList;
import java.util.List;

public class GenBracket {

    ArrayList[] cache = new ArrayList[100];
    public List<String>  genBracket(int n){
        if(cache[n] != null){
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0){
            ans.add("");
        } else {
            for (int i = 0; i < n; i++) {
                for (String left : genBracket(i)){
                    for(String right : genBracket( n - 1 - i)){
                        ans.add(left + '(' + right + ')');
                    }
                }
            }
            cache[n] = ans;
        }
        return cache[n];
    }
}
