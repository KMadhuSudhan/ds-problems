package ds.problems.math;
//https://leetcode.com/problems/smallest-range-i/
//908. Smallest Range I

public class SmallestRangeI {

    public int smallestRangeI(int[] A, int K) {
        int smallestRange = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < A.length; i++)
        {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }

        int back = min + K;
        int front = max - K;

        if(front <= back)
        {
            smallestRange = 0;
        }
        else
        {
            smallestRange = front - back;
        }

        return smallestRange;
    }
}
