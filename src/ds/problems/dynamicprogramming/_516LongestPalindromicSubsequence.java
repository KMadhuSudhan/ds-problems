package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/longest-palindromic-subsequence/
public class _516LongestPalindromicSubsequence {

    public static void main(String[] args) {
        _516LongestPalindromicSubsequence longestPalindromicSubsequence = new _516LongestPalindromicSubsequence();
        longestPalindromicSubsequence.longestPalindromeSubseq("bbbab");
    }
    public int longestPalindromeSubseq(String s) {
        char[] str = s.toCharArray();
        int T[][] = new int[str.length][str.length];
        for(int i=0; i < str.length; i++){
            T[i][i] = 1;
        }
        for(int l = 2; l <= str.length; l++){
            for(int i = 0; i < str.length-l + 1; i++){
                int j = i + l - 1;
                if(l == 2 && str[i] == str[j]){
                    T[i][j] = 2;
                }else if(str[i] == str[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }
        return T[0][str.length-1];
    }
}
