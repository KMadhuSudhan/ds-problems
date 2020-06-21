package ds.problems.string;
//https://leetcode.com/problems/find-and-replace-pattern/
//890. Find and Replace Pattern

import java.util.ArrayList;
import java.util.List;

public class _890FindandReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList();
        for (int i = 0; i < words.length; i++) {
            if(words[i].length()!=pattern.length()) continue;
            if(isIsomorphic(words[i],pattern)) {
                ans.add(words[i]);
            }
        }
        return ans;
    }

    public boolean isIsomorphic(String s, String t) {
        return canbeReplace(s,t) && canbeReplace(t,s);
    }
    public boolean canbeReplace(String s, String t) {
        Character[] map = new Character[256];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (map[sChars[i]] == null) {
                map[sChars[i]] = tChars[i];
            } else if (map[sChars[i]] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}
