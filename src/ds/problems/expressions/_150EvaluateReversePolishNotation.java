package ds.problems.expressions;

import java.util.Stack;

//https://leetcode.com/problems/evaluate-reverse-polish-notation/
//150. Evaluate Reverse Polish Notation
public class _150EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i=0;
        int a,b, newval;
        while(i<tokens.length){
            if(tokens[i].equals("+") ){
                a = stack.pop();
                b = stack.pop();
                newval = a + b;
                stack.push(newval);
            }
            else if(tokens[i].equals("-")){
                a = stack.pop();
                b = stack.pop();
                newval = b - a;
                stack.push(newval);
            }
            else if(tokens[i].equals("*")){
                a = stack.pop();
                b = stack.pop();
                newval = a * b;
                stack.push(newval);
            }
            else if(tokens[i].equals("/")){
                a = stack.pop();
                b = stack.pop();
                newval = b / a;
                stack.push(newval);
            }
            else
            {
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.pop();
    }
}
