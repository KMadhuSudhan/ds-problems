package ds.problems.array;
//https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
//1295. Find Numbers with Even Number of Digits

public class _1295FindNumberswithEvenNumberofDigits {

    public int findNumbers(int[] nums) {
        int count = 0;
        for(int i=0;i<nums.length;i++) {
            if(((int)(Math.floor(Math.log10(nums[i])) + 1) % 2) == 0) count++;
        }
        return count;
    }
}
