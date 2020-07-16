package ds.problems.array;
//https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
//698. Partition to K Equal Sum Subsets

public class _698PartitionToKEqualSumSubsets {

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totSum = 0;
        for(int n: nums) totSum += n;
        if(k==0 || (k!=0 && totSum%k != 0)) return false;
        return partition(nums, k, 0, new boolean[nums.length], 0, totSum/k);
    }
    public boolean partition(int[] nums, int k, int start, boolean[] used, int bucketSum, int targetSum){
        if(k == 1) return true;
        if (bucketSum > targetSum)
            return false;
        if(bucketSum == targetSum)
            return partition(nums, k-1, 0, used, 0, targetSum);

        for(int i= start; i< nums.length; i++){
            int temp = bucketSum + nums[i];
            if(!used[i] && temp <= targetSum){
                used[i] = true;
                if(partition(nums, k, i+1, used, temp, targetSum))
                    return true;
                used[i] = false;
            }
        }
        return false;
    }
}
