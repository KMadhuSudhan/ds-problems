package ds.problems.string;
//https://leetcode.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters/
//1576. Replace All ?'s to Avoid Consecutive Repeating Characters
//https://leetcode.com/problems/number-of-ways-to-split-a-string/discuss/830455/JavaPython-3-Multiplication-of-the-ways-of-1st-and-2nd-cuts-w-explanation-and-analysis.
public class _1576ReplaceAllToAvoidConsecutiveRepeatingCharacters {
    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        if(chars.length == 1) {
            if(chars[0] == '?')  {
                chars[0] = 'a';
            }
            return new String(chars);
        }
        for(int i=1;i<chars.length-1;i++) {
            if(chars[i]!='?') continue;
            for(char j='a';j<='c';j++) {
                if(chars[i-1]!=j && chars[i+1]!=j) {
                    chars[i] = j;
                }
            }
        }
        if(chars[0] == '?') {
            for(char j='a';j<='c';j++) {
                if(chars[1]!=j) {
                    chars[0] = j;
                }
            }
        }
        if(chars[chars.length-1] == '?') {
            for(char j='a';j<='c';j++) {
                if(chars[chars.length-2]!=j) {
                    chars[chars.length-1] = j;
                }
            }
        }
        return new String(chars);
    }
}
