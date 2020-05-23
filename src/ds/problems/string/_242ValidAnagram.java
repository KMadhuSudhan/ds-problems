package ds.problems.string;
//https://leetcode.com/problems/valid-anagram/
//242. Valid Anagram

public class _242ValidAnagram {

    public boolean isAnagram(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        if(sChars.length!=tChars.length) return false;
        int[] map = new int[26];
        for(int i=0;i<sChars.length;i++) {
            map[sChars[i] - 'a']++;
            map[tChars[i] - 'a']--;
        }
        for(int i=0;i<26;i++) {
            if(map[i]>0) {
                return false;
            }
        }
        return true;
    }
}
