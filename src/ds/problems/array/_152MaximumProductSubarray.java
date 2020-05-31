package ds.problems.array;
//https://leetcode.com/problems/maximum-product-subarray/
//152. Maximum Product Subarray

public class _152MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0], min = nums[0], res = max;  // carefull when init max, min;
        for (int i = 1; i < nums.length; i++) {   // start by 1, not 0;
            int maxTmp = Math.max(Math.max(min * nums[i], nums[i]), max * nums[i]);
            int minTmp = Math.min(Math.min(min * nums[i], nums[i]), max * nums[i]);
            max = maxTmp;
            min = minTmp;
            res = Math.max(res, max);
        }
        return res;
    }
}
