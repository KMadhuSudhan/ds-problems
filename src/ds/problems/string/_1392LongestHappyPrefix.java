package ds.problems.string;
//https://leetcode.com/problems/longest-happy-prefix/
//1392. Longest Happy Prefix

public class _1392LongestHappyPrefix {

    public static void main(String[] args) {
        _1392LongestHappyPrefix longestHappyPrefix = new _1392LongestHappyPrefix();
        System.out.print(longestHappyPrefix.longestPrefix("ababab"));
    }
    public String longestPrefix(String s) {
        int[] lps = lps(s.toCharArray());
        return s.substring(0,lps[lps.length-1]);
    }
    int[] lps(char[] chars) {
        int[] lps = new int[chars.length];
        int i=0,j=1;
        while(j<chars.length) {
            if(chars[i] == chars[j]) {
                lps[j] = i+1;
                i++;
                j++;
            } else if(i!=0) {
                i = lps[i-1];
            } else {
                j++;
            }
        }
        return lps;
    }
}
