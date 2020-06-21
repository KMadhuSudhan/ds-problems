package ds.problems.array;
//https://leetcode.com/problems/next-greater-element-ii/
//503. Next Greater Element II

import java.util.Arrays;
import java.util.Stack;

public class _503NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < length * 2; i++) {
            while (!stack.isEmpty() && nums[i%length] >  nums[stack.peek()]) {
                int index = stack.pop();
                result[index] = nums[i%length];
            }
            if(i< nums.length) {
                stack.push(i);
            }
        }
        return result;
    }
}
