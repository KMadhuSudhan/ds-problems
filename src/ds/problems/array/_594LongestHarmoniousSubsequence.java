package ds.problems.array;
//https://leetcode.com/problems/longest-harmonious-subsequence/
//594. Longest Harmonious Subsequence

import java.util.HashMap;

public class _594LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums){
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        for (int key : numMap.keySet()){
            int eachCount = numMap.get(key);
            if (numMap.containsKey(key + 1))
                eachCount += numMap.get(key + 1);
            else
                continue;
            if (eachCount > max)
                max = eachCount;
        }

        return max;
    }
}
