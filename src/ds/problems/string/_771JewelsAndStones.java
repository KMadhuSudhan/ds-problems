package ds.problems.string;
//https://leetcode.com/problems/jewels-and-stones/
//771. Jewels and Stones

public class _771JewelsAndStones {

    public static void main(String[] args) {
        _771JewelsAndStones jewelsAndStones = new _771JewelsAndStones();
        jewelsAndStones.numJewelsInStones("aA","aAAbbbb");
    }

    public int numJewelsInStones(String J, String S) {
        int[] lowerLetters = new int[26];
        int[] upperLetters = new int[26];
        char[] jChars = J.toCharArray();
        char[] sChars = S.toCharArray();

        for(int i=0;i<jChars.length;i++) {
            if(jChars[i] >=65 && jChars[i]<=90) {
                upperLetters[jChars[i] - 'A']++;
            } else {
                lowerLetters[jChars[i] - 'a']++;
            }
        }
        int count = 0;
        for(int i=0;i<sChars.length;i++) {
            if(sChars[i] >=65 && sChars[i]<=90) {
                if(upperLetters[sChars[i] - 'A'] > 0) {
                    count++;
                }
            } else {
                if(lowerLetters[sChars[i] - 'a'] > 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
