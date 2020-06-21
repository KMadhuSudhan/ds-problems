package ds.problems.array;
//https://leetcode.com/problems/non-overlapping-intervals/
//435. Non-overlapping Intervals

import java.util.Arrays;

public class _435NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, (a, b)->a[1] - b[1]);
        int ans = 0;
        for (int i = 0, j = 1; j < intervals.length; j++) {
            //overlap
            if (intervals[i][1] > intervals[j][0]) {
                ans += 1;
            } else {
                // not overalap so far.
                i = j;
            }
        }
        return ans;
    }
}
