package ds.problems.array;
//https://leetcode.com/problems/move-zeroes/
//283. Move Zeroes

public class _283MoveZeroes {
    public static void main(String[] args) {
        _283MoveZeroes moveZeroes = new _283MoveZeroes();
        int[] nums = {0,1,0,3,12};
        moveZeroes.moveZeroes(nums);
    }
    public void moveZeroes(int[] nums) {
        int j=0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]!=0) {
                nums[j] = nums[i];
                j++;
            }
        }
        while(j<nums.length) {
            nums[j] = 0;
            j++;
        }
    }
}
