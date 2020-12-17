package ds.problems.array;
//https://leetcode.com/problems/partition-array-into-disjoint-intervals/
//915. Partition Array into Disjoint Intervals

public class _915PartitionArrayIntoDisjointIntervals {

    public static void main(String[] args) {
        _915PartitionArrayIntoDisjointIntervals partitionArrayIntoDisjointIntervals = new _915PartitionArrayIntoDisjointIntervals();
        int[] a = new int[]{5,0,3,8,6};
        partitionArrayIntoDisjointIntervals.partitionDisjoint(a);
    }
    public int partitionDisjoint(int[] A) {
        int[] maxarr = new int[A.length];
        int[] minarr = new int[A.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++) {
           max = Math.max(max,A[i]);
           maxarr[i] = max;
        }

        for(int i=A.length-1;i>=0;i--) {
            min = Math.min(min,A[i]);
            minarr[i] = min;
        }
        for(int i=0;i<A.length-1;i++) {
            if(maxarr[i]<=minarr[i+1]) return i+1;
        }
        return -1;
    }
}
