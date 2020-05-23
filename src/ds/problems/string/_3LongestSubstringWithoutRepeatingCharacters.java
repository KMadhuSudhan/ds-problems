package ds.problems.string;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/
//3. Longest Substring Without Repeating Characters

import java.util.HashSet;
import java.util.Set;

public class _3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        _3LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters = new _3LongestSubstringWithoutRepeatingCharacters();
        String str = "abcabcbb";
        longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(str);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        char[] chars = s.toCharArray();
        int i = 0, j = 0, maxLength = 0;
        while (i < chars.length) {
            if (!set.contains(chars[i])) {
                set.add(chars[i]);
                i++;
                maxLength = Math.max(maxLength, i - j);
            } else {
                set.remove(chars[j]);
                j++;
            }
        }
        return maxLength;
    }
}
