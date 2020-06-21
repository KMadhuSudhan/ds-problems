package ds.problems.stack;
//https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
//921. Minimum Add to Make Parentheses Valid

import java.util.Stack;

public class _921MinimumAddtoMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Stack<Character> s = new Stack();
        int ans = 0;
        for(int i = 0 ; i < S.length() ; i++){
            if(S.charAt(i) == '(')
                s.push(S.charAt(i));
            else{
                if(!s.empty()){
                    s.pop();
                }
                else
                    ans++;
            }
        }
        while(!s.empty()){
            ans++;
            s.pop();
        }
        return ans;
    }

}
