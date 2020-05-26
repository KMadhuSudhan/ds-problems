package ds.problems.string;
//https://leetcode.com/problems/longest-common-prefix/
//14. Longest Common Prefix

public class _14LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        char[] chars = strs[0].toCharArray();
        for(int i=0;i<chars.length;i++) {
            boolean matched = true;
            for(int j=1;j<strs.length;j++) {
                if( i>=strs[j].length() || strs[j].charAt(i) != chars[i]) {
                    matched = false;
                    break;
                }
            }
            if(matched == false) break;
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
