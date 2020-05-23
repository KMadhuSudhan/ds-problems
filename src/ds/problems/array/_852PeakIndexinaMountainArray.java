package ds.problems.array;
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
//852. Peak Index in a Mountain Array

public class _852PeakIndexinaMountainArray {

    public int peakIndexInMountainArray(int[] A) {
        if(A.length <3) return 0;
        int i=0;
        while(i+1<A.length && A[i]<A[i+1]) {
            i++;
        }
        return i;
    }
}
