package ds.problems.array;

import java.util.PriorityQueue;

public class _1005MaximizeSumOfArrayAfterKNegations {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> minHeap = new  PriorityQueue<Integer>();
        for ( int a : A ) minHeap.add(a);
        // for K times , pick the smallest element , multiple by -1 andd into PQ .
        // replace A[i] with -A[i], and we repeat this process K times in total.
        while( K-- > 0 )  minHeap.add((-1)*minHeap.remove());
        // Now add all elements , which will give max sum .
        int sum =0 ;
        while(!minHeap.isEmpty()) sum+= minHeap.remove();
        return(sum);
    }
}
