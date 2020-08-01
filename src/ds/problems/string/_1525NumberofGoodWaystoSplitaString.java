package ds.problems.string;
//https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
//1525. Number of Good Ways to Split a String

public class _1525NumberofGoodWaystoSplitaString {
    public static void main(String[] args) {
        _1525NumberofGoodWaystoSplitaString numberofGoodWaystoSplitaString = new _1525NumberofGoodWaystoSplitaString();
        System.out.println(numberofGoodWaystoSplitaString.numSplits("ababbbbbbb"));
    }
    public int numSplits(String s) {
        int[] rightMap = new int[26];
        int[] leftMap = new int[26];
        char[] characters = s.toCharArray();
        int left = 0,right = 0,count = 0;
        for(char c: characters) {
            if(rightMap[c - 'a'] == 0) {
                right++;
            }
            rightMap[c - 'a']++;
        }
        if(right == 1) return characters.length - 1;
        for(int i=0;i<characters.length;i++) {
            if(leftMap[characters[i] - 'a'] == 0) {
                left++;
            }
            rightMap[characters[i] - 'a']--;
            if(rightMap[characters[i] - 'a'] == 0) {
                right --;
            }
            leftMap[characters[i] - 'a']++;
            if(left == right){
                count++;
            }
        }
        return count;
    }

}
