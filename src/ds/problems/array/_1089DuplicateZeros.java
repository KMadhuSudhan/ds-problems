package ds.problems.array;
//https://leetcode.com/problems/duplicate-zeros/
//1089. Duplicate Zeros

public class _1089DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int zeros = 0;
        for(int num: arr) {
            if(num == 0) zeros++;
        }
        int[] nums = new int[arr.length + zeros];
        int i=0,j=0;
        while(j<arr.length) {
            if(arr[j] == 0) {
                nums[i++] = 0;
                nums[i++] = 0;
            } else {
                nums[i++] = arr[j];
            }
            j++;
        }
        for(i=0;i<arr.length;i++) {
            arr[i] = nums[i];
        }
    }
}
