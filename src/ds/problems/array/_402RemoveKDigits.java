package ds.problems.array;
//https://leetcode.com/problems/remove-k-digits/
//402. Remove K Digits

import java.util.Stack;

public class _402RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(k == num.length()) return "0";

        Stack<Character> stk = new Stack<>();
        for(char c : num.toCharArray()){
            while(!stk.isEmpty() && k > 0 && stk.peek() > c){
                stk.pop();
                k--;
            }
            stk.push(c);
        }

        for(int i = 0; i < k; i++){
            stk.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();

        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }
}
