package ds.problems.array;
//https://leetcode.com/problems/missing-number/
//268. Missing Number

public class _268MissingNumber {

    public static void main(String[] args) {
        _268MissingNumber missingNumber = new _268MissingNumber();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        missingNumber.missingNumber(nums);
    }
    public int missingNumber(int[] nums) {

        int missingNum = nums.length;

        for(int i = 0; i < nums.length; i++)
        {
            missingNum ^= i;
            missingNum ^= nums[i];
        }

        return missingNum;
    }
}
