package ds.problems.array;
//https://leetcode.com/problems/minimum-increment-to-make-array-unique/
//945. Minimum Increment to Make Array Unique

import java.util.Arrays;

public class _945MinimumIncrementtoMakeArrayUnique {
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int ans = 0;
        for(int i=1;i<A.length;i++) {
            if(A[i] < A[i-1] +1) {
                ans+= A[i-1] +1 - A[i];
                A[i] = A[i-1] +1;
            }
        }
        return ans;
    }
}
