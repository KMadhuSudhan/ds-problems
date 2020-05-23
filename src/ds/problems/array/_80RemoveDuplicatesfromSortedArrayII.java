package ds.problems.array;

public class _80RemoveDuplicatesfromSortedArrayII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        _80RemoveDuplicatesfromSortedArrayII removeDuplicatesfromSortedArrayII = new _80RemoveDuplicatesfromSortedArrayII();
        removeDuplicatesfromSortedArrayII.removeDuplicates(nums);
    }
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;

        int dupe_count = 0;
        for (int i = 2; i < nums.length; i++)
        {
            nums[i - dupe_count] = nums[i];
            if (nums[i] == nums[i-dupe_count-2]) dupe_count++;
        }
        return (nums.length - dupe_count);
    }
}
