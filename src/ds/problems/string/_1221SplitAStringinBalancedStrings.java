package ds.problems.string;
//https://leetcode.com/problems/split-a-string-in-balanced-strings/
//1221. Split a String in Balanced Strings

public class _1221SplitAStringinBalancedStrings {

    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int count = 0,ans = 0;
        for(int i=0;i<chars.length;i++) {
            if(chars[i] == 'R') {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                ans++;
            }
        }
        return ans;
    }
}
