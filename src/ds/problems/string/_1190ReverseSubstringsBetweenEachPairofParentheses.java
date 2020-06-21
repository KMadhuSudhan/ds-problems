package ds.problems.string;
//https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/
//1190. Reverse Substrings Between Each Pair of Parentheses

import java.util.Stack;

public class _1190ReverseSubstringsBetweenEachPairofParentheses {

    public String reverseParentheses(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == ')') {
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }
                stack.pop();
                char[] pairChars = sb.toString().toCharArray();
                for(int j=0;j<pairChars.length;j++) {
                    stack.push(pairChars[j]);
                }
            } else {
                stack.push(chars[i]);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()) {
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}
