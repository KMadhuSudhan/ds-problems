package ds.problems.string;
//https://leetcode.com/problems/repeated-substring-pattern/
//459. Repeated Substring Pattern

public class _459RepeatedSubstringPattern {
    public static void main(String[] args) {
        _459RepeatedSubstringPattern substringPattern = new _459RepeatedSubstringPattern();
        substringPattern.repeatedSubstringPattern("abab");
    }
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] table = new int[chars.length];
        int j=0,i=1;
        while(i<chars.length) {
            if(chars[i] == chars[j]) {
                table[i] = j+1;
                i++;
                j++;
            } else if(j> 0) {
                j = table[j-1];
            } else {
                i++;
            }
        }
        if(table[chars.length-1] == 0) return false;
        int num = chars.length -  table[chars.length-1];
        if(chars.length % num !=0) return false;
        return true;
    }
}
