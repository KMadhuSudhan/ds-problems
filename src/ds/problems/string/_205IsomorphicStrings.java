package ds.problems.string;

//https://leetcode.com/problems/isomorphic-strings/
//
public class _205IsomorphicStrings {
    public static void main(String[] args) {
        _205IsomorphicStrings isomorphicStrings = new _205IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
    }

    public boolean isIsomorphic(String s, String t) {
        return canbeReplace(s,t) && canbeReplace(t,s);
    }

    public boolean canbeReplace(String s, String t) {
        Character[] map = new Character[256];
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            if (map[sChars[i]] == null) {
                map[sChars[i]] = tChars[i];
            } else if (map[sChars[i]] != tChars[i]) {
                return false;
            }
        }
        return true;
    }
}
