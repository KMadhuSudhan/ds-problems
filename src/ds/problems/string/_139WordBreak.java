package ds.problems.string;
//https://leetcode.com/problems/word-break/
//139. Word Break

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dic = new HashSet<>(wordDict);
        List<Integer> successes = new ArrayList<>();
        for (int right = 1; right <= s.length(); right++) {
            // Check if the whole substring to the left is a word.
            if (dic.contains(s.substring(0, right))) {
                successes.add(right);
                continue;
            }
            for (int i = successes.size()-1; i >= 0; i--) {
                // Check only the substrings starting at the previous solutions' endpoints.
                int successIndex = successes.get(i);
                if (dic.contains(s.substring(successIndex, right))) {
                    successes.add(right);
                    break;
                }
            }
        }

        // If we found a success ending at the length of s, then s is a solution--what we're checking for in the first place.
        return !successes.isEmpty() && successes.get(successes.size()-1) == s.length();
    }
}
