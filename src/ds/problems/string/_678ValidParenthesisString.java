package ds.problems.string;
//https://leetcode.com/problems/valid-parenthesis-string/
//678. Valid Parenthesis String

public class _678ValidParenthesisString {
    public static void main(String[] args) {
        _678ValidParenthesisString validParenthesisString = new _678ValidParenthesisString();
        System.out.println(validParenthesisString.checkValidString(")("));
    }
    public boolean checkValidString(String s) {
        char[] chars = s.toCharArray();
        int starCount = 0,i=0,top = -1;
        char[] stack = new char[chars.length];
        while(i<chars.length) {
            if(top == -1 || chars[i] == '(') {
                stack[++top] = chars[i];
            } else if(chars[i] == '*') {
                starCount++;
            } else {
                if(chars[top] == '(') {
                    top--;
                } else if(starCount >0) {
                    starCount--;
                } else {
                    return false;
                }
            }
            i++;
        }

        while(top>=0) {
            if(top >= 0 && chars[top] == '(' && starCount >0) {
                starCount--;
                top--;
            }

            else if(top >= 0 && chars[top] == ')' && starCount >0) {
                starCount--;
                top--;
            } else {
                return false;
            }
        }
        return top == -1;
    }
}
