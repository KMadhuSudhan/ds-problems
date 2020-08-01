package ds.problems.array;
//https://leetcode.com/problems/132-pattern/
//456. 132 Pattern

import java.util.Stack;

public class _456_132Pattern {
    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) return false;
        Stack<Integer> stack = new Stack();
        int second = Integer.MIN_VALUE;
        int i=nums.length-1;
        while(i>=0) {
            if(nums[i] < second) return true;
            else {
                while(!stack.isEmpty() && stack.peek() < nums[i]) {
                    second = stack.pop();
                }
            }
            stack.push(nums[i--]);
        }
        return false;
    }
}
