package ds.problems.array;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
//154. Find Minimum in Rotated Sorted Array II

public class _154FindMinimuminRotatedSortedArrayII {
    public int findMin(int[] nums) {
        if(nums[0]<nums[nums.length-1])
        {
            return nums[0];
        }
        int low = 0, high = nums.length-1;
        while(low<high)
        {
            int mid  = low + (high-low)/2;
            if(nums[mid]>nums[high])
            {
                low = mid+1;
            }
            else if(nums[mid]<nums[high])
            {
                high = mid;
            }
            else
            {
                high--;
            }
        }
        return nums[low];
    }
}
