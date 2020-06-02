package ds.problems.math;
//https://leetcode.com/problems/integer-replacement/
//397. Integer Replacement

public class _397IntegerReplacement {

    public int integerReplacement(int n) {
        if(n == Integer.MAX_VALUE) return 32;
        return minops(n,0);
    }

    private int minops(int n, int count){
        if(n == 1) return count;
        if(n % 2 == 0) return minops(n / 2, count + 1);
        return Math.min(minops(n + 1, count + 1), minops(n - 1, count + 1));
    }
}
