package ds.problems.array;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
//84. Largest Rectangle in Histogram

import java.util.Stack;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
//84. Largest Rectangle in Histogram

public class _84LargestRectangleinHistogram {
    public int largestRectangleArea(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i=0,area=0,maxArea=0;//4,3
        while(i<a.length) {
            if(stack.isEmpty() || a[stack.peek()] <= a[i]) {
                stack.push(i++);
            } else {
                int topVal = a[stack.peek()];
                area = topVal * i;
                stack.pop();
                if (!stack.isEmpty()) {
                    area = topVal * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int topVal = a[stack.peek()];
            area = topVal * i;
            stack.pop();
            if (!stack.isEmpty()) {
                area = topVal * (i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
