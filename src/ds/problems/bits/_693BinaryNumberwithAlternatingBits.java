package ds.problems.bits;
//https://leetcode.com/problems/binary-number-with-alternating-bits/
//693. Binary Number with Alternating Bits

public class _693BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int prevBit = n%2;
        n /=2;
        while(n!=0) {
            int currentBit = n%2;
            if(prevBit == currentBit) return false;
            prevBit = currentBit;
            n/=2;
        }
        return true;
    }
}
