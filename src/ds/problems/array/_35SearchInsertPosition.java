package ds.problems.array;
//https://leetcode.com/problems/search-insert-position/
//35. Search Insert Position

public class _35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0,high = nums.length-1;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return high + 1;
    }
}
