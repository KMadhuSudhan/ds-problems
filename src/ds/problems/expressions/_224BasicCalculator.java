package ds.problems.expressions;
//https://leetcode.com/problems/basic-calculator/
//224. Basic Calculator

import java.util.Stack;

public class _224BasicCalculator {
    public int calculate(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') continue;
            if(chars[i]!=')') {
                stack.push(chars[i]);
                continue;
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty() && stack.peek() != '(') {
                sb.insert(0,stack.pop());
            }
            stack.pop();
            int val = evalString(sb.toString());
            String evalStr = Integer.toString(val);
            char[] evalChars = evalStr.toCharArray();
            int j;
            if (!stack.isEmpty() && stack.peek() == '-' && evalChars[0] == '-') {
                stack.pop();
                stack.push('+');
                j = 1;
            } else {
                j = 0;
            }
            while (j < evalChars.length) {
                stack.push(evalChars[j]);
                j++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        int ans = evalString(sb.toString());
        return ans;
    }

    public int evalString(String s) {
        char op = '+';
        s += op;
        char[] chars = s.toCharArray();
        int num = 0, answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = num * 10 + chars[i] - '0';
                continue;
            }
            if (chars[i] == ' ') continue;
            switch (op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
            }
            op = chars[i];
            num = 0;
        }
        while (!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}
