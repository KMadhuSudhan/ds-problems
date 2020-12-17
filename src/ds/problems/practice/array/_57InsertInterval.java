package ds.problems.practice.array;
//https://leetcode.com/problems/insert-interval/
//57. Insert Interval

import java.util.ArrayList;
import java.util.List;

public class _57InsertInterval {
    public static void main(String[] args) {
        _57InsertInterval insertInterval = new _57InsertInterval();
        int[][] intervals = new int[][]{
                {1,3},
                {6,9}
        };
        int[] newInterval = new int[]{2,5};
        insertInterval.insert(intervals,newInterval);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList();
        for(int i=0;i<intervals.length;i++) {
            if(intervals[i][1]< newInterval[0]) {
                list.add(intervals[i]);
            } else if(newInterval[1] < intervals[i][0]) {
                list.add(newInterval);
                newInterval = intervals[i];
            } else {
                newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
                newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            }
        }
        list.add(newInterval);
        return list.toArray(new int[list.size()][]);
    }
}
