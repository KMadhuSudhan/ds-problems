package ds.problems.string;
//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
//1614. Maximum Nesting Depth of the Parentheses

public class _1614MaximumNestingDepthOfTheParentheses {
    public int maxDepth(String s) {
        char[] chars = s.toCharArray();
        int left = 0,right = 0,max = 0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == '(' || chars[i] == ')') {
                if(chars[i] == '(') {
                    left++;
                } else {
                    right++;
                }
            }
            max = Math.max(max,left - right);
        }
        return max;
    }
}
