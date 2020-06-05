package ds.problems.array;
//https://leetcode.com/problems/patching-array/
//330. Patching Array

public class _330PatchingArray {

    public int minPatches(int[] nums, int n) {
        long maxReach = 0;
        int ans = 0;
        for(int i = 0; maxReach < n;) {
            if(i < nums.length && nums[i] <= (maxReach + 1)) {
                maxReach = maxReach + nums[i];
                i++;
            } else {
                maxReach = maxReach + maxReach + 1;
                ans++;
            }
        }
        return ans;
    }
}
