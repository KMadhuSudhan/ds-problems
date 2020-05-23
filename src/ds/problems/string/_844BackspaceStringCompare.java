package ds.problems.string;
//https://leetcode.com/problems/backspace-string-compare/
//844. Backspace String Compare

public class _844BackspaceStringCompare {
    public static void main(String[] args) {
        _844BackspaceStringCompare backspaceStringCompare = new _844BackspaceStringCompare();
        System.out.println(backspaceStringCompare.backspaceCompare("aaa###a","aaaa###a"));
    }
    public boolean backspaceCompare(String S, String T) {
        char[] sChars = S.toCharArray();
        char[] tChars = T.toCharArray();
        int sEnd = sChars.length - 1,tEnd = tChars.length - 1;
        while (sEnd >= 0 || tEnd >= 0) {

            //tchars
            int tSpacesCount = 0;
            int backSpacesCount;
            while (tEnd >=0 && tChars[tEnd] == '#') {
                tSpacesCount++;
                tEnd--;
            }
            backSpacesCount = tSpacesCount;
            while (tEnd>=0  && backSpacesCount > 0) {
                if(tChars[tEnd] == '#') {
                    backSpacesCount++;
                    tEnd--;
                    continue;

                }
                tChars[tEnd] = '#';
                backSpacesCount--;
                tEnd--;
            }

            //schars
            int sBackSpacesCount = 0;
            while (sEnd >= 0 && sChars[sEnd] == '#') {
                sBackSpacesCount++;
                sEnd--;
            }
            backSpacesCount = sBackSpacesCount;
            while (sEnd>=0 && backSpacesCount > 0) {
                if(sChars[sEnd] == '#') {
                    backSpacesCount++;
                    sEnd--;
                    continue;
                }
                sChars[sEnd] = '#';
                backSpacesCount--;
                sEnd--;
            }
            if (sBackSpacesCount == 0) sEnd--;
            if (tSpacesCount == 0) tEnd--;
        }
        int i = 0, j = 0;
        while (i < sChars.length && tEnd < tChars.length) {
            while (i < sChars.length && sChars[i] == '#') {
                i++;
            }
            while (j < tChars.length && tChars[j] == '#') {
                j++;
            }
            if(i == sChars.length && j == tChars.length) return true;
            if(i < sChars.length && j < tChars.length && sChars[i] == tChars[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
