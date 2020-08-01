package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/wildcard-matching/
//44. Wildcard Matching

public class _44WildcardMatching {
    public boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] ptr = p.toCharArray();
        int writeIndex = 0;
        boolean isFirst = true;
        for(int i=0;i<ptr.length;i++) {
            if(ptr[i] == '*') {
                if(isFirst) {
                    ptr[writeIndex++] = ptr[i];
                    isFirst = false;
                }
            } else {
                ptr[writeIndex++] = ptr[i];
                isFirst = true;
            }
        }
        boolean[][] T = new boolean[str.length +1][writeIndex+1];
        if (writeIndex > 0 && ptr[0] == '*') {
            T[0][1] = true;
        }
        T[0][0] = true;
        for(int i=1;i<T.length;i++) {
            for(int j=1;j<T[0].length;j++) {
                if(str[i-1] == ptr[j-1] || ptr[j-1] == '?') {
                    T[i][j] = T[i-1][j-1];
                } else if(ptr[j-1] == '*') {
                    T[i][j] = T[i-1][j] || T[i][j-1];
                }
            }
        }
        return T[str.length][writeIndex];
    }
}
