package ds.problems.string;
//https://leetcode.com/problems/is-subsequence/
//392. Is Subsequence

public class _392IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        char[] tChars = t.toCharArray();
        char[] sChars = s.toCharArray();
        int i=0,j=0;
        while(i<tChars.length) {
            if( j < sChars.length && tChars[i] == sChars[j]) {
                j++;
            }
            i++;
        }
        return j==sChars.length;
    }
}
