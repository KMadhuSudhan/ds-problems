package ds.problems.array;
//https://leetcode.com/problems/find-peak-element/
//162. Find Peak Element

public class _162FindPeakElement {
    public int findPeakElement(int[] A) {
        int i=0;
        while(i+1<A.length && A[i]<A[i+1]) {
            i++;
        }
        return i;
    }
}
