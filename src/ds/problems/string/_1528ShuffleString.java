package ds.problems.string;
//https://leetcode.com/problems/shuffle-string/
//1528. Shuffle String

public class _1528ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        char[] ans = new char[chars.length];
        for(int i=0;i<chars.length;i++) {
            ans[indices[i]] = chars[i];
        }
        return new String(ans);
    }
}
