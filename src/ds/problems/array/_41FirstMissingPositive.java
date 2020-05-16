package ds.problems.array;
//https://leetcode.com/problems/first-missing-positive/
//41. First Missing Positive

public class _41FirstMissingPositive {

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        _41FirstMissingPositive firstMissingPositive = new _41FirstMissingPositive();
        firstMissingPositive.firstMissingPositive(nums);
    }

    public int firstMissingPositive(int[] nums) {
        int length = nums.length;
        if (length == 0) return 1;
        for (int i = 0; i < nums.length; i++) {
            while (i < length) {
                if (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
                    swap(nums, i, nums[i] - 1);
                } else {
                    i++;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return length + 1;
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
