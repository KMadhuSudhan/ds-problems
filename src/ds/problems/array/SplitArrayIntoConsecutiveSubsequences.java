package ds.problems.array;
//https://leetcode.com/problems/split-array-into-consecutive-subsequences/
//659. Split Array into Consecutive Subsequences

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences {

    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            if (map.get(num) == 0) continue;
            int count = 0;
            while (map.containsKey(num) && map.get(num) > 0) {
                count++;
                if (count > 3 && map.get(num) <= map.get(num - 1)) break;
                map.put(num, map.get(num) - 1);
                num++;
            }
            if (count < 3) return false;
        }
        return true;
    }
}
