package ds.problems.string;
//https://leetcode.com/problems/find-the-difference/
//389. Find the Difference

public class _389FindTheDifference {
    public static void main(String[] args) {
        _389FindTheDifference findTheDifference = new _389FindTheDifference();
        findTheDifference.findTheDifference("abcd", "abcde");
    }

    public char findTheDifference(String s, String t) {
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] map = new int[26];
        for (int i = 0; i < sChars.length; i++) {
            map[tChars[i] - 'a']++;
            map[sChars[i] - 'a']--;
        }
        map[tChars[tChars.length - 1] - 'a']++;
        for (int i = 0; i < 26; i++) {
            if (map[i] != 0) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
}
