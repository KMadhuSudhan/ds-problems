package ds.problems.array;

public class _414ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        _414ThirdMaximumNumber thirdMaximumNumber = new _414ThirdMaximumNumber();
        thirdMaximumNumber.thirdMax(nums);
    }
    public int thirdMax(int[] nums) {
        long firstMax = Long.MIN_VALUE;
        long secondMax = Long.MIN_VALUE;
        long thirdMax = Long.MIN_VALUE;
        for(int i=0;i<nums.length;i++) {
            if(firstMax < nums[i]) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = (long) nums[i];
            } else if(secondMax < nums[i] && nums[i] < firstMax) {
                thirdMax = secondMax;
                secondMax = (long) nums[i];
            } else if(thirdMax < nums[i] && nums[i]  < secondMax) {
                thirdMax = (long) nums[i];
            }
        }
        if(thirdMax == Long.MIN_VALUE) {
            return (int) firstMax;
        }
        return (int) thirdMax;
    }
}
