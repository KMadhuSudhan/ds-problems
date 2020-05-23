package ds.problems.array;
//https://leetcode.com/problems/monotonic-array/
//896. Monotonic Array

public class _896MonotonicArray {

    public boolean isMonotonic(int[] A) {
        int i=0;
        while(i+1 < A.length && A[i] == A[i+1]) {
            i++;
        }
        if(i+1 == A.length) return true;
        boolean increasing  = A[i] < A[i+1];
        while(i<A.length-1) {
            if(increasing) {
                if(A[i] <= A[i+1]) {
                    i++;
                } else {
                    break;
                }
            } else {
                if(A[i] >= A[i+1]) {
                    i++;
                } else {
                    break;
                }
            }
        }
        return i == A.length-1;
    }
}
