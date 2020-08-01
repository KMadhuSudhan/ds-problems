package ds.problems.string;
//https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts/
//1371. Find the Longest Substring Containing Vowels in Even Counts

import java.util.HashMap;
import java.util.Map;

public class _1371FindTheLongestSubstringContainingVowelsInEvenCount {

    public int findTheLongestSubstring(String s) {
        int res = 0 , cur = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1 ) >> 1;
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }

    //sliding window
    public int findTheLongestSubstringSlidingWindow(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        int l=0,max=0;
        for(int i=0;i<chars.length;i++) {
            map[chars[i] - 'a']++;
            int[] temp = new int[26];
            for(int j=0;j<26;j++) {
                temp[j] = map[j];
            }
            while(temp[0]%2 == 1 || temp[4]%2 == 1 || temp[8]%2 == 1 || temp[14]%2 == 1 || temp[20]%2 == 1) {
                temp[chars[l] - 'a']--;
                l++;
            }
            max = Math.max(max,i-l+1);
            l=0;
        }
        return max;
    }
}
