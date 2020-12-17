package ds.problems.array;
//https://leetcode.com/problems/longest-well-performing-interval/
//1124. Longest Well-Performing Interval

import java.util.HashMap;

public class _1124LongestWellPerformingInterval {
    public int longestWPI(int[] hours) {
        if (hours.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap();
        int max = 0;
        int sum = 0;
        for (int i = 0; i < hours.length; i++) {
            sum += hours[i] > 8 ? 1 : -1;
            if (!map.containsKey(sum)) map.put(sum, i);
            if (sum > 0) max = i+1;
            else if (map.containsKey(sum - 1)) {
                max = Math.max(max, i - map.get(sum-1));
            }
        }
        return max;
    }
}
