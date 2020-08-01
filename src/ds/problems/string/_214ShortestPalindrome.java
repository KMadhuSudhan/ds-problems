package ds.problems.string;
//https://leetcode.com/problems/shortest-palindrome/
//214. Shortest Palindrome

public class _214ShortestPalindrome {
    public static void main(String[] args) {
        _214ShortestPalindrome shortestPalindrome = new _214ShortestPalindrome();
        shortestPalindrome.shortestPalindrome("aacecaaa");
    }

    public String shortestPalindrome(String s) {
        String r = new StringBuilder(s).reverse().toString();
        int[] lps = getLPS(s + '|' + r);
        return r.substring(0, r.length() - lps[lps.length - 1]) + s;
    }

    int[] getLPS(String s) {
        char[] chars = s.toCharArray();
        int[] lps = new int[chars.length];
        int i = 0, j = 1;
        while (j < chars.length) {
            if (chars[i] == chars[j]) {
                lps[j] = i + 1;
            } else if (i != 0) {
                i = lps[i - 1];
            } else {
                j++;
            }
        }
        return lps;
    }
}
