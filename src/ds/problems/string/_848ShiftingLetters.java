package ds.problems.string;
//https://leetcode.com/problems/shifting-letters/
//848. Shifting Letters

public class _848ShiftingLetters {
    public static void main(String[] args) {
        _848ShiftingLetters shiftingLetters = new _848ShiftingLetters();
        int[] shifts = {26,9,17};
        System.out.println(shiftingLetters.shiftingLetters("ruu",shifts));
    }
    public String shiftingLetters(String S, int[] shifts) {
        char[] chars = S.toCharArray();
        int sum = 0;
        for(int i=chars.length-1;i>=0;i--) {
            sum+= shifts[i];
            sum = sum %26;
            chars[i] = (char) ((chars[i]-'a' + sum )%26 + 'a');
        }
        return new String(chars);
    }
}
