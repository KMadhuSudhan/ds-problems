package ds.problems.array;
//https://leetcode.com/problems/degree-of-an-array/
//697. Degree of an Array

import java.util.HashMap;
import java.util.Map;

public class _697DegreeOfArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> first = new HashMap<>(), cnt = new HashMap<>();
        int res = Integer.MAX_VALUE, max = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            cnt.put(n, cnt.getOrDefault(n, 0) + 1);
            if (!first.containsKey(n)) first.put(n, i);
            if (cnt.get(n) > max) {
                max = cnt.get(n);
                res =  i - first.get(n) + 1;
            } else if (cnt.get(n) == max) {
                res = Math.min(res, i - first.get(n) + 1);
            }
        }
        return res;
    }
}
