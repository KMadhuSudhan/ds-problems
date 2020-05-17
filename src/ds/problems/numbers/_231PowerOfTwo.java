package ds.problems.numbers;
//https://leetcode.com/problems/power-of-two/
//231. Power of Two

public class _231PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Math.log10(n)/Math.log10(2) % 1 == 0;
    }
}
