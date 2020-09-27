package ds.problems.bits;
//https://leetcode.com/problems/bitwise-and-of-numbers-range
//201. Bitwise AND of Numbers Range


public class BitwiseAndOfNumbersRange {
    public int rangeBitwiseAnd(int m, int n) {
        while (m < n) n-=(n&-n);
        return n;
    }
}
