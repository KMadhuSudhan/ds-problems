package ds.problems.string;
//https://leetcode.com/problems/length-of-last-word/
//58. Length of Last Word

public class _58LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        char[] chars = s.toCharArray();
        int count = 0;
        for(int i=chars.length-1;i>=0;i--) {
            if(chars[i] == ' ')  {
                return count;
            }
            count++;
        }
        return chars.length;
    }
}
