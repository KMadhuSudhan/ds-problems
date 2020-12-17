package ds.problems.string;

public class _796RotateString {
    public boolean rotateString(String A, String B) {
        if(A.length()!=B.length()) return false;
        A = A + A;
        char[] aChars = A.toCharArray();
        char[] bChars = B.toCharArray();
        int[] lps = buildLPS(bChars);
        return kmpSearch(aChars,bChars,lps);
    }
    boolean kmpSearch(char[] aChars,char[] bChars,int[] lps) {
        int i=0,j=0;
        while(i<aChars.length && j < bChars.length) {
            if(aChars[i] == bChars[j]) {
                i++;
                j++;
            } else {
                if(j!=0) {
                    j = lps[j-1];
                }  else {
                    i++;
                }
            }
        }
        return j == bChars.length;
    }
    int[] buildLPS(char[] bChars) {
        int i=1,j=0;
        int[] lps = new int[bChars.length];
        while(i<bChars.length) {
            if(bChars[i] == bChars[j]) {
                lps[i] = j+1;
                i++;
                j++;
            } else {
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
        }
        return lps;
    }
}
