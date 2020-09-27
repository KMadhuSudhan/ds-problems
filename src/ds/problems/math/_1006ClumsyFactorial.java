package ds.problems.math;
//https://leetcode.com/problems/clumsy-factorial/
//1006. Clumsy Factorial

import java.util.Stack;

public class _1006ClumsyFactorial {
    public static void main(String[] args) {
        _1006ClumsyFactorial clumsyFactorial = new _1006ClumsyFactorial();
        System.out.println(clumsyFactorial.clumsy(10));
    }

    int[] lowerValues = {0, 1, 2, 6, 7}, rest = {1, 2, 2, -1};
    int clumsy(int n) {
        if (n < 5) return lowerValues[n];
        else return n + rest[n % 4];
    }

    //public int clumsy(int N) {
      //  return calculate(N);
    //}
    public int calculate(int N) {
        char[] operations = {'*','/','+','-'};
        int count = 0;
        Stack<Integer> stack = new Stack();
        int num = N, answer = 0;
        num--;
        stack.push(N);
        while (num>0) {
            char op = operations[count%4];
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
            count++;
            num--;
        }
        while(!stack.isEmpty()) {
            answer+=stack.pop();
        }
        return answer;
    }
}
