package ds.problems.string;
//https://leetcode.com/problems/custom-sort-string/
//791. Custom Sort String

public class _791CustomSortString {
    public static void main(String[] args) {

    }
    public String customSortString(String S, String T) {
        char[] chars = T.toCharArray();
        char[] sChars = S.toCharArray();
        int[] cnt = new int[26];
        for(char c:chars) {
            cnt[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(char c : sChars) {
            if(cnt[c - 'a']-- > 0) {
                sb.append(c);
            }
        }
        for(int i=0;i<26;i++) {
            while (cnt[i]-->0) {
                sb.append( (char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
