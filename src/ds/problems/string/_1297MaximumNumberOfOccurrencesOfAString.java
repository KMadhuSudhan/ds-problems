package ds.problems.string;
//https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/
//1297. Maximum Number of Occurrences of a Substring

import java.util.HashSet;
import java.util.Set;

public class _1297MaximumNumberOfOccurrencesOfAString {
    public static void main(String[] args) {
        _1297MaximumNumberOfOccurrencesOfAString maximumNumberOfOccurrencesOfAString = new _1297MaximumNumberOfOccurrencesOfAString();
        System.out.println(maximumNumberOfOccurrencesOfAString.maxFreq("aababcaab", 2, 3, 4));
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] chars = s.toCharArray();
        int i = 0, j = 0, count = 0;
        Set<Character> set = new HashSet<>();
        while (i < chars.length) {
            set.add(chars[i]);
            if(set.size() <= maxLetters && i - j >=minSize && i-j<=maxSize) {
                count++;
                set.remove(chars[j]);
                j++;
            }
            i++;
        }
        return count;
    }
}
