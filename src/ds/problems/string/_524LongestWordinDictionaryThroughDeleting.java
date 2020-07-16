package ds.problems.string;
//https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/
//524. Longest Word in Dictionary through Deleting

import java.util.List;

public class _524LongestWordinDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        char[] sChars = s.toCharArray();
        String ans = "";
        for(String str: d) {
            char[] chars = str.toCharArray();
            int i=0,j=0;
            while(i<sChars.length && j < chars.length) {
                if(sChars[i] == chars[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                }
            }
            if(j == str.length()) {
                if(str.length() > ans.length()) {
                    ans = str;
                } else {
                    if(str.length() == ans.length()) {
                        if(str.compareTo(ans) < 0) {
                            ans = str;
                        }
                    }
                }
            }
        }
        return ans;
    }
}
