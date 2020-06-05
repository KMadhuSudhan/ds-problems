package ds.problems.array;
//https://leetcode.com/problems/maximum-width-ramp/
//962. Maximum Width Ramp

import java.util.Stack;

public class _962MaximumWidthRamp {

    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack();
        int res = 0, n = A.length;
        for (int i = 0; i < n; ++i){
            if (stack.isEmpty() || A[stack.peek()] > A[i]) stack.push(i);
        }
        for (int i = n - 1; i > res; --i){
            while (!stack.isEmpty() && A[stack.peek()] <= A[i]){
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
