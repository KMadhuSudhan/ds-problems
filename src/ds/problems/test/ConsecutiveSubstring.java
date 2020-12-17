package ds.problems.test;

public class ConsecutiveSubstring {
    public int longestConsecutiveSubstring(char[] chars) {
        int n = chars.length,i=0,dots = 0,maxLen = 0,len = 0;
        while(i<n && (chars[i]!='A' || chars[i]!= '.')) {
            i++;
        }
        if(i == n) return 0;
        char prevChar = 'A';
        i++;
        while(i<chars.length) {
            while(i<chars.length && ((prevChar + 1) == chars[i] || chars[i] == '.')) {
                if(chars[i]!='.') {
                    prevChar = chars[i];
                    dots = 0;
                } else {
                    dots++;
                    prevChar = (char) (prevChar  + 1);
                }
                len++;
                i++;
            }
            maxLen = Math.max(maxLen,len);
            if(i == chars.length) break;
            len = (chars[i] - 'A') <= dots ? dots - (chars[i] - 'A') : 0 ;
            while(len==0 && i < chars.length && chars[i] != 'A' || chars[i] != '.') {
                i++;
            }
            prevChar = 'A';
        }
        return maxLen;
    }
}
