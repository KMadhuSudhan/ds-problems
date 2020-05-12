package ds.problems.slidingwindow;
//https://leetcode.com/problems/max-consecutive-ones-iii/
//1004. Max Consecutive Ones III

public class _1004MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        _1004MaxConsecutiveOnesIII maxConsecutiveOnesIII = new _1004MaxConsecutiveOnesIII();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        maxConsecutiveOnesIII.longestOnes(nums,2);
    }

    public int longestOnes(int[] A, int K) {
        int low=0,zeros=0,maxSize=0;
        for(int high=0;high<A.length;high++) {
            if(A[high] == 0) {
                zeros++;
            }
            while (zeros > K) {
                if(A[low] == 0) {
                    zeros--;
                }
                low++;
            }
            maxSize = Math.max(maxSize,high-low+1);
        }
        return maxSize;
    }
}
