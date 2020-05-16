package ds.problems.array;

public class _287FindTheDuplicateNumber {
    public static void main(String[] args) {
        _287FindTheDuplicateNumber findTheDuplicateNumber = new _287FindTheDuplicateNumber();
        int[] nums = {1,3,4,2,2};
        findTheDuplicateNumber.findDuplicate(nums);
    }
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];

            fast = nums[nums[fast]];

        } while (slow != fast);

        fast = 0;

        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return slow;
    }
}
