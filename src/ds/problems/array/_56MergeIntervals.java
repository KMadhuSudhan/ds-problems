package ds.problems.array;
//https://leetcode.com/problems/merge-intervals/
//56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _56MergeIntervals {
    public static void main(String[] args) {
        _56MergeIntervals mergeIntervals = new _56MergeIntervals();
        int[][] intervels = {
                {1,3},
                {2,6},
                {8,10},
                {15,18}
        };
    }

    public int[][] merge(int[][] intervals) {
        int length = intervals.length;
        if(length == 0) return new int[][]{};
        List<int[]> lists = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int min = intervals[0][0],max = intervals[0][1];
        for (int i=1;i<length;i++) {
            if(intervals[i][0] <= max) {
                min = Math.min(min, intervals[i][0]);
                max = Math.max(max, intervals[i][1]);
            } else {
                List<Integer> list = new ArrayList<>();
                lists.add(new int[]{min,max});
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }
        lists.add(new int[]{min,max});
        return lists.toArray(new int[lists.size()][]);
    }
}
