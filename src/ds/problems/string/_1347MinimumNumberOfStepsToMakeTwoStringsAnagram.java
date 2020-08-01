package ds.problems.string;
//https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/
//1347. Minimum Number of Steps to Make Two Strings Anagram

public class _1347MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public static void main(String[] args) {
        _1347MinimumNumberOfStepsToMakeTwoStringsAnagram minimumNumberOfStepsToMakeTwoStringsAnagram = new _1347MinimumNumberOfStepsToMakeTwoStringsAnagram();
        System.out.print(minimumNumberOfStepsToMakeTwoStringsAnagram.minSteps("bab","aba"));
    }

    public int minSteps(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] cnt = new int[26];
        for(int i=0;i<sChars.length;i++) {
            cnt[sChars[i] - 'a']++;
            cnt[tChars[i] - 'a']--;
        }
        int ans = 0;
        for(int i=0;i<26;i++) {
            ans += Math.abs(cnt[i]);
        }
        return ans/2;
    }
}

