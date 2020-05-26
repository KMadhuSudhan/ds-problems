package ds.problems.array;
//https://leetcode.com/problems/insert-interval/
//57. Insert Interval

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _57InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int length = intervals.length;
        if (length == 0) return new int[][]{{newInterval[0], newInterval[1]}};
        int[][] mergedInterval = new int[length+1][2];
        for (int i=0;i<length;i++) {
            mergedInterval[i] = intervals[i];
        }
        mergedInterval[length] = new int[]{newInterval[0], newInterval[1]};
        List<int[]> lists = new ArrayList<>();
        Arrays.sort(mergedInterval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int min = mergedInterval[0][0],max = mergedInterval[0][1];
        for (int i=1;i<=length;i++) {
            if(mergedInterval[i][0] <= max) {
                min = Math.min(min, mergedInterval[i][0]);
                max = Math.max(max, mergedInterval[i][1]);
            } else {
                lists.add(new int[]{min,max});
                min = mergedInterval[i][0];
                max = mergedInterval[i][1];
            }
        }
        lists.add(new int[]{min,max});
        return lists.toArray(new int[lists.size()][]);
    }
}
