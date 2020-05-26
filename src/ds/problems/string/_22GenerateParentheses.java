package ds.problems.string;
//https://leetcode.com/problems/generate-parentheses/
//22. Generate Parentheses

import java.util.ArrayList;
import java.util.List;

public class _22GenerateParentheses {
    List<String> ans = new ArrayList();
    public static void main(String[] args) {
        _22GenerateParentheses generateParentheses = new _22GenerateParentheses();
        System.out.println(generateParentheses.generateParenthesis(3));
    }
    public List<String> generateParenthesis(int n) {
        char[] str = new char[2 * n];
        generateParenthesis(n,str,0,0,0);
        return ans;
    }
    public void generateParenthesis(int n,char[] sb,int pos,int open,int close) {
        if(close == n) {
            ans.add(new String(sb));
        } else {
            if (open > close) {
                sb[pos] = ')';
                generateParenthesis(n, sb, pos + 1, open, close + 1);
            }
            if(open < n) {
                sb[pos] = '(';
                generateParenthesis(n, sb, pos + 1, open + 1, close);
            }
        }
    }
}
