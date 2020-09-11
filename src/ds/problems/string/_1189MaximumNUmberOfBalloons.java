package ds.problems.string;
//https://leetcode.com/problems/maximum-number-of-balloons/submissions/
//1189. Maximum Number of Balloons
public class _1189MaximumNUmberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        char[] baloon = new char[] {'b','a','l','l','o','o','n'};
        int[] textCnt = new int[26];
        for(char ch: text.toCharArray()) {
            textCnt[ch - 'a']++;
        }
        textCnt['o' - 'a'] /= 2;
        textCnt['l' - 'a'] /= 2;
        int minVal = text.length();
        for(char c : baloon){
            minVal = Math.min(minVal, textCnt[c - 'a']);
        }
        return minVal;
    }
}
