package ds.problems.string;
//https://leetcode.com/problems/longest-palindrome/
//409. Longest Palindrome

public class _409LongestPalindrome {
    public int longestPalindrome(String s) {
        char[] sChar = s.toCharArray();
        int[] alphabet = new int[256];
        int count = 0;
        for(int i = 0; i < sChar.length; i++)
            if(++alphabet[sChar[i]] % 2 == 0)
                count += 2;
        return (sChar.length - count != 0) ? count + 1 : count;
    }
}
