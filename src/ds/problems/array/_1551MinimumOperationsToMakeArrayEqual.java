package ds.problems.array;
//https://leetcode.com/problems/minimum-operations-to-make-array-equal/
//1551. Minimum Operations to Make Array Equal
//https://leetcode.com/problems/minimum-operations-to-make-array-equal/discuss/794267/return-n*n4-directly
//((2+2n-2)n/2)/2 = nn/4.
public class _1551MinimumOperationsToMakeArrayEqual {
    public int minOperations(int n) {
        return n*n/4;
    }
}
