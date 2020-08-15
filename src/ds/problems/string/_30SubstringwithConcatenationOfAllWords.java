package ds.problems.string;
//https://leetcode.com/problems/substring-with-concatenation-of-all-words/
//30. Substring with Concatenation of All Words

import java.util.*;

public class _30SubstringwithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        if(words.length == 0) return new ArrayList();
        Map<String,Integer> map = new HashMap();
        for(String word: words) {
            int count = map.getOrDefault(word,0);
            map.put(word,count+1);
        }
        int wordLen = words[0].length();
        int totalWords = words.length;
        List<Integer> ans = new ArrayList();

        for(int i=0;i<=s.length()-wordLen*totalWords;i++) {
            Map<String,Integer> seen = new HashMap();
            int j;
            for(j=0;j<totalWords;j++) {
                int nextWordIndex = i + j * wordLen;
                String word = s.substring(nextWordIndex,nextWordIndex + wordLen);
                if(!map.containsKey(word)) {
                    break;
                }
                int count = seen.getOrDefault(word,0);
                count++;
                if(count > map.get(word)) {
                    break;
                }
                seen.put(word,count);
            }
            if(j == totalWords) {
                ans.add(i);
            }
        }
        return ans;
    }
}
