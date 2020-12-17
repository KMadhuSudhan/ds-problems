package ds.problems.array;
//https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/
//795. Number of Subarrays with Bounded Maximum

public class _795NumberOfSubarraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int pvc = 0,i=0,j=0,ans = 0;
        while(i<A.length) {
            if(A[i]>=L && A[i]<=R) {
                pvc = i - j +1;
                ans+= i - j +1;
            } else if(A[i] < L) {
                ans+= pvc;
            } else {
                pvc = 0;
                j = i+1;
            }
            i++;
        }
        return ans;
    }
}
