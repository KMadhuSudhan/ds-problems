package ds.problems.string;
//https://leetcode.com/problems/palindrome-partitioning/
//131. Palindrome Partitioning

import java.util.ArrayList;
import java.util.List;

public class _131PalindromePartitioning {

    List<List<String>> result = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<String>());
        return result;
    }
    public void dfs(String s, int index, List<String> list){
        if(index == s.length()){
            result.add(new ArrayList<String>(list));
            return;
        }
        for(int i = index+1; i <= s.length(); i++){
            if(isPallindrome(s.substring(index, i))){
                list.add(s.substring(index, i));
                dfs(s, i, list);
                list.remove(list.size()-1);
            }
        }
    }

    public boolean isPallindrome(String s){
        for(int i = 0; i <= s.length()/2; i++)
            if(s.charAt(i) != s.charAt(s.length()-i-1))   return false;
        return true;
    }

}
