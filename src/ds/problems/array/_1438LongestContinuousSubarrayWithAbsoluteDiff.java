package ds.problems.array;
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
//1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

import java.util.ArrayDeque;
import java.util.Deque;

public class _1438LongestContinuousSubarrayWithAbsoluteDiff {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};

        _1438LongestContinuousSubarrayWithAbsoluteDiff longestContinuousSubarrayWithAbsoluteDiff = new _1438LongestContinuousSubarrayWithAbsoluteDiff();
        System.out.println(longestContinuousSubarrayWithAbsoluteDiff.longestSubarray(nums,4));
    }
    public int longestSubarray(int[] A, int limit) {
        Deque<Integer> maxd = new ArrayDeque<>();
        Deque<Integer> mind = new ArrayDeque<>();
        int i = 0, j;
        for (j = 0; j < A.length; ++j) {
            while (!maxd.isEmpty() && A[j] > maxd.peekLast()) maxd.pollLast();
            while (!mind.isEmpty() && A[j] < mind.peekLast()) mind.pollLast();
            maxd.add(A[j]);
            mind.add(A[j]);
            if (maxd.peek() - mind.peek() > limit) {
                if (maxd.peek() == A[i]) maxd.poll();
                if (mind.peek() == A[i]) mind.poll();
                ++i;
            }
        }
        return j - i;
    }
}
