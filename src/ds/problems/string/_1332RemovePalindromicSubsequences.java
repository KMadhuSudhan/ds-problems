package ds.problems.string;
//https://leetcode.com/problems/remove-palindromic-subsequences/
//1332. Remove Palindromic Subsequences

public class _1332RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        if(s.isEmpty())
            return 0;
        StringBuilder str=new StringBuilder(s);
        if(s.equals(str.reverse().toString()))
            return 1;
        return 2;
    }
}
