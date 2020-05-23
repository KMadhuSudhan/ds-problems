package ds.problems.system.design;
//https://leetcode.com/problems/online-stock-span
//901. Online Stock Span


import java.util.Stack;

public class _901OnlineStockSpan {

    Stack<int[]> stack;
    public _901OnlineStockSpan() {
        stack = new Stack();
    }

    public int next(int price) {
        int span = 1;
        while(!stack.isEmpty() && stack.peek()[0]<= price) {
            span += stack.peek()[1];
            stack.pop();
        }
        stack.push(new int[] {price,span});
        return span;
    }
}
