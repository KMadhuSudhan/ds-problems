package ds.problems.bits;
//https://leetcode.com/problems/number-of-substrings-with-only-1s/
//1513. Number of Substrings With Only 1s

public class NumberofSubstringsWithOnly1s {

    public int numSub(String s) {
        int res = 0, count = 0, mod = (int)1e9 + 7;
        for (int i = 0; i < s.length(); ++i) {
            count = s.charAt(i) == '1' ? count + 1 : 0;
            res = (res + count) % mod;
        }
        return res;
    }
}
