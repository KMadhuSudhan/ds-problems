package ds.problems.array;
//https://leetcode.com/problems/two-sum/
//1. Two Sum

import java.util.HashMap;
import java.util.Map;

public class _1TwoSum {
    public static void main(String[] args) {
        _1TwoSum twoSum = new _1TwoSum();
        int[] nums = {2, 7, 11, 15};
        twoSum.twoSum(nums,9);
    }
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            int diff = target - nums[i];
            if(map.containsKey(diff)) {
                indices[0] = i;
                indices[1] = map.get(diff);
                return indices;
            }
            map.put(nums[i],i);
        }
        return indices;
    }
}
