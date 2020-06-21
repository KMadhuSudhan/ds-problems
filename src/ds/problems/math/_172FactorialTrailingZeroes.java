package ds.problems.math;
//https://leetcode.com/problems/factorial-trailing-zeroes/
//172. Factorial Trailing Zeroes

public class _172FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;
        for (long i = 5; i <= n; i *= 5)
            count += n / i;
        return count;
    }
}
