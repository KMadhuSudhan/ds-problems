package ds.problems.backtracking;
//https://leetcode.com/problems/next-permutation/
//31. Next Permutation

public class _31NextPermutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        _31NextPermutation nextPermutation = new  _31NextPermutation();
        nextPermutation.nextPermutation(nums);
    }
    public void nextPermutation(int[] nums) {
        int peak = -1;
        for(int i=nums.length-1;i>0;i--) {
            if(nums[i-1] < nums[i]) {
                peak = i-1;
                break;
            }
        }
        if(peak!=-1) {
            for(int i=nums.length-1;i>0;i--) {
                if(nums[i] > nums[peak]) {
                    int temp = nums[i];
                    nums[i] = nums[peak];
                    nums[peak] = temp;
                    break;
                }
            }
        }
        int start = peak == -1 ? 0 : peak+1;
        int end = nums.length-1;
        while(start<end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
