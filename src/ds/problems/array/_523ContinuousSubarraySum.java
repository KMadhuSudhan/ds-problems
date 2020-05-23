package ds.problems.array;
//https://leetcode.com/problems/continuous-subarray-sum/
//523. Continuous Subarray Sum

import java.util.HashMap;
import java.util.Map;

public class _523ContinuousSubarraySum {
    public static void main(String[] arg) {
        _523ContinuousSubarraySum continuousSubarraySum = new _523ContinuousSubarraySum();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(continuousSubarraySum.checkSubarraySum(nums,6));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, sum = 0; i < nums.length; ++i) {
            sum += nums[i];
            int rem = k == 0 ? sum : sum % k;
            if (map.containsKey(rem)) {
                if (map.get(rem) <= i - 2) return true;
            } else map.put(rem, i);
        }
        return false;
    }
}
