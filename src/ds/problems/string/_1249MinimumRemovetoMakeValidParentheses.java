package ds.problems.string;
//https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
//1249. Minimum Remove to Make Valid Parentheses

import java.util.Stack;

public class _1249MinimumRemovetoMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack();
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(s);
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == '(') {
                stack.push(i);
            } else if(chars[i] == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                } else {
                    sb.setCharAt(i,'#');
                }
            }
        }
        while(!stack.isEmpty()) {
            sb.setCharAt(stack.pop(),'#');
        }
        return sb.toString().replace("#", "");
    }
}
