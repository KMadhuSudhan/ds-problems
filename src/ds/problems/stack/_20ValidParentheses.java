package ds.problems.stack;
//https://leetcode.com/problems/valid-parentheses/
//20. Valid Parentheses

public class _20ValidParentheses {

    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        char[] stack = new char[chars.length];
        int top = -1;
        if(chars.length == 0) return true;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == ')' && top!=-1 && stack[top] == '(') {
                top--;
                // stack.pop();
            } else if(chars[i] == '}' && top!=-1 && stack[top] == '{') {
                top--;
                // stack.pop();
            } else if(chars[i] == ']' && top!=-1 && stack[top] == '[') {
                top--;
                // stack.pop();
            } else {
                stack[++top] = chars[i];
            }
        }
        return top == -1;
    }
}
