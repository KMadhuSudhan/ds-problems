package ds.problems.array;
//https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
//34. Find First and Last Position of Element in Sorted Array

public class _34FindFirstandLastPositionofElementinSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int low = 0,high = nums.length-1,mid =-1;
        while(low<=high) {
            mid = low + (high - low)/2;
            if(nums[mid] == target) {
                break;
            }
            if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        if(nums.length == 0 || nums[mid]!=target) {
            return new int[] {-1,-1};
        }
        int i=mid-1;
        int j=mid+1;
        while(i>=0 && nums[i] == target){ i--;}
        while(j<nums.length && nums[j] == target) {j++;}
        return new int[]{i+1,j-1};
    }
}
