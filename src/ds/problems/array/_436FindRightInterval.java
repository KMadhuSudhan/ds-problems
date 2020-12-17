package ds.problems.array;
//https://leetcode.com/problems/find-right-interval/
//436. Find Right Interval

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class _436FindRightInterval {

    public static void main(String[] args) {

    }
    public int[] findRightInterval(int[][] intervals) {
        Map<int[],Integer> map = new HashMap<>();
        for(int  i=0;i<intervals.length;i++) {
            map.put(intervals[i],i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int compare = o1[0] - o2[0];
                if(compare!=0) return compare;
                return o1[1] - o2[1];
            }
        });
        int end = intervals[0][1];
        int[] ans = new int[intervals.length];
        Arrays.fill(ans,-1);
        for(int i=1;i<intervals.length;i++) {
            int start = intervals[i][0];
            if(start>=end) {
                ans[map.get(intervals[i])] = map.get(intervals[i]);
            }
        }
        return ans;
    }
}
