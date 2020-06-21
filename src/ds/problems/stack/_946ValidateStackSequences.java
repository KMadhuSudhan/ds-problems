package ds.problems.stack;

//https://leetcode.com/problems/validate-stack-sequences/
//946. Validate Stack Sequences

import java.util.Stack;

public class _946ValidateStackSequences {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if(pushed.length == 0 || popped.length == 0) return true;
        if(pushed.length > 0 && popped.length == 0) return false;
        if(pushed.length == 0 && popped.length > 0) return false;
        Stack<Integer> stack = new Stack();
        int i = 1,j = 0;
        stack.push(pushed[0]);
        while(i<pushed.length) {
            if(!stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j++;
            } else {
                stack.push(pushed[i]);
                i++;
            }
        }
        while(j<popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
            stack.pop();
            j++;
        }
        return stack.isEmpty();
    }

}
