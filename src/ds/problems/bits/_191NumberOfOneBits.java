package ds.problems.bits;
//https://leetcode.com/problems/number-of-1-bits/
//191. Number of 1 Bits
public class _191NumberOfOneBits {

    public int hammingWeight(int n) {
        int bits = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                bits++;
            }
            n = n >>> 1;
        }
        return bits;
    }
}
