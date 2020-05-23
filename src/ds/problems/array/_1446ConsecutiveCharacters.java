package ds.problems.array;
//https://leetcode.com/problems/consecutive-characters/
//1446. Consecutive Characters

public class _1446ConsecutiveCharacters {
    public static void main(String[] args) {
        String str = "abbcccddddeeeeedcba";
        _1446ConsecutiveCharacters consecutiveCharacters = new _1446ConsecutiveCharacters();
        consecutiveCharacters.maxPower(str);
    }
    public int maxPower(String s) {
        char[] chars = s.toCharArray();
        int i=0,max=0,j;
        while(i<chars.length) {
            j=i;
            while(j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            max = Math.max(max,j-i);
            i=j;
        }
        return max;
    }
}
