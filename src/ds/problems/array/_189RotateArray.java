package ds.problems.array;

public class _189RotateArray {

    public void rotate(int[] nums, int k) {
        if(nums.length == 0 || k == 0 || k % nums.length == 0)  return;
        k = k % nums.length;
        k = nums.length - k;
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
        reverse(nums,0,nums.length-1);
    }

    void reverse(int[] nums,int start,int end) {
        while(start<end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
