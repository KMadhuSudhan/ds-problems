package ds.problems.array;
//https://leetcode.com/problems/maximum-sum-obtained-of-any-permutation/
//1589. Maximum Sum Obtained of Any Permutation

import java.util.Arrays;

public class _1589MaximumSumObtainedOfAnyPermutation {
    public int maxSumRangeQuery(int[] A, int[][] requests) {
        int res = 0, mod = (int)1e9 + 7, n = A.length;
        int[] count = new int[n];
        for (int[] r: requests) {
            count[r[0]] += 1;
            if (r[1] + 1 < n)
                count[r[1] + 1] -= 1;
        }
        for (int i = 1; i < n; ++i)
            count[i] += count[i - 1];
        Arrays.sort(A);
        Arrays.sort(count);
        for (int i = 0; i < n; ++i)
            res = (res + A[i] * count[i]) % mod;
        return res;
    }
}
