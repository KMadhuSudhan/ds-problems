package ds.problems.array;
//https://leetcode.com/problems/k-diff-pairs-in-an-array/
//532. K-diff Pairs in an Array

import java.util.HashMap;
import java.util.Map;

public class _532KDiffPairs {

    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<0) return 0;
        int count = 0;
        Map<Integer, Integer> diffMap = new HashMap();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int rCount = diffMap.getOrDefault(nums[i], 0);
            diffMap.put(nums[i], rCount + 1);
        }
        for (Map.Entry<Integer, Integer> entry : diffMap.entrySet()) {
            int key = entry.getKey();
            if (k != 0 && diffMap.containsKey(k + key)) {
                count++;
            }
            if (k == 0 && entry.getValue() >= 2) count++;
        }

        return count;
    }
}
