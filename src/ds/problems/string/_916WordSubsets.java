package ds.problems.string;

import java.util.ArrayList;
import java.util.List;

public class _916WordSubsets {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> ans = new ArrayList();
        int[] maxCharCounts = new int[26];
        for(String word: B) {
            int[] charCounts = new int[26];
            for (char c : word.toCharArray()) {
                charCounts[c - 'a']++;
            }
            for (int i=0; i<26; i++) {
                maxCharCounts[i] = Math.max(maxCharCounts[i], charCounts[i]);
            }
        }

        for(String word: A) {
            boolean isUniversal = true;
            char[] chars = word.toCharArray();
            int[] aCnt = new int[26];
            for(char ch: chars) {
                aCnt[ch - 'a']++;
            }
            for(int i=0;i<26;i++) {
                if(aCnt[i]<maxCharCounts[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if(isUniversal) {
                ans.add(word);
            }
        }
        return ans;
    }
}
