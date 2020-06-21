package ds.problems.array;
//https://leetcode.com/problems/longest-uncommon-subsequence-i/
//521. Longest Uncommon Subsequence I

public class _521LongestUncommonSubsequenceI {

    public int findLUSlength(String a, String b) {
        if(a.equals(b)) {
            return -1;
        }
        return Math.max(a.length(),b.length());
    }
}
