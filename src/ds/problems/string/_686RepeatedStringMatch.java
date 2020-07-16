package ds.problems.string;
//https://leetcode.com/problems/repeated-string-match/
//686. Repeated String Match

public class _686RepeatedStringMatch {
    public static void main(String[] args) {

    }

    public int repeatedStringMatch(String A, String B) {
        int[] lps = generateKMPLPS(B);
        StringBuilder newStr = new StringBuilder();
        int count = 0;
        while(newStr.length() < B.length()) {
            newStr.append(A);
            count++;
        }
        if(kmpSearch(newStr.toString(),B,lps)) return count;
        if(kmpSearch(newStr.append(A).toString(),B,lps)) return count+1;
        return -1;
    }

    boolean kmpSearch(String A, String B,int[] lps) {
        int i=0,j=0;
        while(i<A.length()) {
            if(A.charAt(i) == B.charAt(j)) {
                i++;
                j++;
            } else {
                if(j!=0) {
                    j = lps[j-1];
                } else {
                    i++;
                }
            }
            if(j == B.length()) {
                return true;
            }
        }
        return false;
    }

    int[] generateKMPLPS(String B) {
        char[] chars = B.toCharArray();
        int[] lps = new int[chars.length];
        int i=1,j=0;
        while(i<chars.length) {
            if(chars[i] == chars[j]) {
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
