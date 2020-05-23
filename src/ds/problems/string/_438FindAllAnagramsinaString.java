package ds.problems.string;
//https://leetcode.com/problems/find-all-anagrams-in-a-string/
//438. Find All Anagrams in a String

import java.util.ArrayList;
import java.util.List;

public class _438FindAllAnagramsinaString {
    public static void main(String[] args) {
        _438FindAllAnagramsinaString findAllAnagramsinaString = new _438FindAllAnagramsinaString();
        System.out.println(findAllAnagramsinaString.findAnagrams("cbaebabacd","abc"));
    }
    public List<Integer> findAnagrams(String s, String p) {
        char[] sChars = s.toCharArray();
        char[] pChars = p.toCharArray();
        int[] map = new int[26];
        List<Integer> result = new ArrayList<>();
        int i,j;
        for(i=0;i<pChars.length;i++) {
            map[pChars[i] - 'a']++;
        }
        i = 0;
        j=0;
        while(i<sChars.length) {
            // valid anagram
            if(map[s.charAt(i) - 'a'] > 0){
                map[s.charAt(i++) - 'a']--;
                // window size equal to size of P
                if(i-j ==  p.length()){
                    result.add(i);
                }
            }
            // window is of size 0
            else if(i == j){
                i ++;
                j ++;
            }
            // decrease window size
            else{
                map[s.charAt(j++) - 'a']++;
            }
        }
        return result;
    }
}
