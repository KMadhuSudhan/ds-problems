package ds.problems.string;
//https://leetcode.com/problems/implement-strstr/
//28. Implement strStr()

public class _28ImplementStrStr {
    public static void main(String[] args) {
        _28ImplementStrStr implementStrStr = new _28ImplementStrStr();
        implementStrStr.strStr("mississippi","issip");
    }
    public int strStr(String string, String pattern) {
        int[] table = new int[pattern.length()];
        char[] chars = pattern.toCharArray();
        char[] strchars = string.toCharArray();
        if(chars.length == 0) return 0;
        int j=0,i=1;
        while (i<chars.length){
            if(chars[i] == chars[j]) {
                table[i] = j  + 1;
                j++;
                i++;
            } else if(j>0) {
                j = table[j-1];
            } else {
                i++;
            }
        }

        i=0;
        j=0;
        while (i<strchars.length && j < chars.length) {
            while (j > 0 && strchars[i] != chars[j]) j = table[j - 1];
            if (strchars[i] == chars[j]) ++j;
            ++i;
            if (j == chars.length) return i - j;
        }
        return -1;
    }
}
