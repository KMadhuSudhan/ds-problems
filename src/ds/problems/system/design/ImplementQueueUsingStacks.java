package ds.problems.system.design;
//https://leetcode.com/problems/implement-queue-using-stacks/
//232. Implement Queue using Stacks

import java.util.Stack;

public class ImplementQueueUsingStacks {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        stack1 = new Stack();
        stack2 = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        while(!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
