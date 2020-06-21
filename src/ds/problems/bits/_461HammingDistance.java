package ds.problems.bits;
//https://leetcode.com/problems/hamming-distance/
//461. Hamming Distance

public class _461HammingDistance {

    public int hammingDistance(int x, int y) {
        int xor = x ^ y, result = 0;
        while (xor > 0) {
            result += xor & 1;
            xor = xor >> 1;
        }
        return result;
    }
}
