package ds.problems.string;
//https://leetcode.com/problems/detect-capital/
//520. Detect Capital

public class _520DetectCapital {

    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        if(chars.length>=2 && (chars[0] >=65 && chars[0] <=90) && (chars[1] >=65 && chars[1] <=90)) {
            return allCapital(chars);
        }
        if(chars[0] >=97) {
            return allSmall(chars,0);
        }
        if(chars.length>=1 && (chars[0] >=65 && chars[0] <=90)) {
            return allSmall(chars,1);
        }
        return false;
    }
    boolean allCapital(char[] chars) {
        for(int i=0;i<chars.length;i++) {
            if(chars[i]<65 || chars[i] > 90) {
                return false;
            }
        }
        return true;
    }

    boolean allSmall(char[] chars,int start) {
        for(int i=start;i<chars.length;i++) {
            if(chars[i]<97 || chars[i] > 122) {
                return false;
            }
        }
        return true;
    }
}
