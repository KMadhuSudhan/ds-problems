package ds.problems.array;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//167. Two Sum II - Input array is sorted

public class _167TwoSumIIInputarrayissorted {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        _167TwoSumIIInputarrayissorted twoSumIIInputarrayissorted = new _167TwoSumIIInputarrayissorted();
        twoSumIIInputarrayissorted.twoSum(nums,9);
    }
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        int low = 0,high=nums.length-1;
        while(low<high) {
            if(nums[low] + nums[high] == target) {
                indices[0] = low+1;
                indices[1] = high+1;
                return indices;
            }
            else if(nums[low] + nums[high] > target) {
                high--;
            } else {
                low++;
            }
        }
        return indices;
    }
}
