package ds.problems.array;

import java.util.*;

public class FindRightInterval {
    public static void main(String[] args) {
        FindRightInterval findRightInterval = new FindRightInterval();
        int[][] input = new int[][] {
                {-100,-98},
                {-99,-97},
                {-98,-96}
        };
        findRightInterval.findRightInterval(input);
    }
    public int[] findRightInterval(int[][] intervals) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<intervals.length;i++) {
            map.put(intervals[i][0]*10 + intervals[i][1],i);
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int compare = o1[0] - o2[0];
                if(compare!=0) return compare;
                return o2[1] - o1[1];
            }
        });
        int[] ans = new int[intervals.length];
        Arrays.fill(ans,-1);
        Set<Integer> set = new HashSet<>();
        int end = intervals[0][1];
        for(int i=1;i<intervals.length;i++) {
            int start = intervals[i][0];

            if(start>= end) {
                set.add(i-1);
                for (Iterator<Integer> j = set.iterator(); j.hasNext();) {
                    Integer element = j.next();
                    int prevEnd = intervals[element][1];
                    if (prevEnd <= start) {
                        int index = map.get(intervals[element][0]*10 + intervals[element][1]);
                        int originalIndex = map.get(start*10 + intervals[i][1]);
                        ans[index] = originalIndex;
                        j.remove();
                    }
                }
            } else {
                set.add(i-1);
            }
                end = intervals[i][1];
        }
        return ans;
    }
}
