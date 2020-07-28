package ds.problems.string;
//https://leetcode.com/problems/word-break/
//139. Word Break

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _139WordBreak {

    public boolean wordBreakWithoutTrie(String s, List<String> wordDict) {
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

    private class Node {
        /**
         * key is child c
         */
        private Node[] children;
        private boolean isWord;

        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }
    Node root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Node();
        for (String word: wordDict) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                Node node = cur.children[index];
                if (node == null) {
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.isWord = true;
        }
        return wordBreak(s, wordDict, 0, new boolean[s.length()], root);
    }

    private boolean wordBreak(String s, List<String> wordDict, int index, boolean[] dp, Node root) {

        if (dp[index]) return false;

        Node cur = root;
        for (int i = index; i < s.length(); ++i) {
            Node node = cur.children[s.charAt(i) - 'a'];
            if (node == null) {
                break;
            } else if (node.isWord) {
                //found one
                if (i == s.length() - 1 || wordBreak(s, wordDict, i + 1, dp, root)) {
                    return true;
                }
            }
            cur = node;
        }
        dp[index] = true;
        return false;
    }
}
