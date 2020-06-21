package ds.problems.expressions;
//https://leetcode.com/problems/basic-calculator-ii/
//227. Basic Calculator II

import java.util.Stack;

public class _227BasicCalculatorII {
    public int calculate(String s) {
        char op = '+';
        s+=op;
        char[] chars = s.toCharArray();
        int ans = 0;

        Stack<Integer> stack = new Stack();
        int num = 0, answer = 0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == ' ') {
                continue;
            }
            if(chars[i]>= '0' && chars[i]<= '9') {
                num = num*10 + chars[i] - '0';
                continue;
            }
            switch(op) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
            }
            op = chars[i];
            num = 0;
        }
        while(!stack.isEmpty()) {
            answer+=stack.pop();
        }
        return answer;
    }
}
