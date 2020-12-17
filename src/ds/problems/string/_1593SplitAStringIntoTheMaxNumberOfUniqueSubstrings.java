package ds.problems.string;
//https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings/
//1593. Split a String Into the Max Number of Unique Substrings

import java.util.HashSet;
import java.util.Set;

public class _1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings {
    public static void main(String[] args) {
        _1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings splitAStringIntoTheMaxNumberOfUniqueSubstrings = new _1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings();
        splitAStringIntoTheMaxNumberOfUniqueSubstrings.maxUniqueSplit("ababccc");
    }
    int max = 0;
    public int maxUniqueSplit(String s) {
        dfs(s, 0, s.length(), new HashSet<String>());
        return max;
    }

    void dfs(String s, int st, int e, Set<String> seen) {
        if (st == s.length()) {
            max = Math.max(max, seen.size());
            return;
        }

        for (int i = st; i < e; i++) {
            String sub = s.substring(st, i+1);
            if (!seen.contains(sub)) {
                seen.add(sub);
                dfs(s, i+1, e, seen);
                seen.remove(sub);
            }
        }
    }
}
