package ds.problems.array;
//https://leetcode.com/problems/remove-covered-intervals/
//1288. Remove Covered Intervals

import java.util.Arrays;
import java.util.Comparator;

public class _1288RemoveCoveredIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {
                {1,4},
                {3,6},
                {2,8}
        };
        _1288RemoveCoveredIntervals removeCoveredIntervals = new _1288RemoveCoveredIntervals();
        removeCoveredIntervals.removeCoveredIntervals(intervals);
    }
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int compare = o1[0] - o2[0];
                if(compare!=0) return compare;
                return o1[1] - o2[1];
            }
        });
        int count = 0;
        int min = intervals[0][0];
        int max = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            int iMin = intervals[i][0];
            int iMax = intervals[i][1];
            if(min<=iMin && max>=iMax) {
                count++;
            } else {
                min = iMin< min ? iMin : min;
                max = iMax > max ? iMax : max;
            }
        }
        return intervals.length - count;
    }
}
