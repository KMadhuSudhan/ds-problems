package ds.problems.array;
//https://leetcode.com/problems/shortest-unsorted-continuous-subarray/
//581. Shortest Unsorted Continuous Subarray

public class _581ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        _581ShortestUnsortedContinuousSubarray shortestUnsortedContinuousSubarray = new _581ShortestUnsortedContinuousSubarray();
        int[] nums = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(shortestUnsortedContinuousSubarray.findUnsortedSubarray(nums));
    }
    private int min(int[] nums, int start, int end) {
        int ans = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            ans = Math.min(ans, nums[i]);
        }
        return ans;
    }

    private int max(int[] nums, int start, int end) {
        int ans = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            ans = Math.max(ans, nums[i]);
        }
        return ans;
    }

    public int findUnsortedSubarray(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < nums.length - 1 && nums[l] <= nums[l + 1]) {
            l++;
        }
        if (l == nums.length - 1) {
            return 0;
        }
        while (r >= 1 && nums[r] >= nums[r - 1]) {
            r--;
        }


        // System.out.println(l + ":" + r);
        int lmax = max(nums, 0, r);
        int rmin = min(nums, l + 1, nums.length);
        // System.out.println(lmax + ":" + rmin);
        while (l >= 0 && nums[l] > rmin) {
            l--;
        }
        while (r < nums.length && nums[r] < lmax) {
            r++;
        }
        // System.out.println(l + ":" + r);
        return r - l - 1;
    }
}
