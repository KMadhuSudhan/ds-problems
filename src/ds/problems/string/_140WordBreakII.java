package ds.problems.string;
//https://leetcode.com/problems/word-break-ii/
//140. Word Break II

import java.util.ArrayList;
import java.util.List;

public class _140WordBreakII {
    private class Node {
        /**
         * key is child c
         */
        private Node[] children;
        private int markWordIndex = -1;

        public Node() {
            children = new Node[26];
        }
    }
    Node root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new Node();
        for (int i=0;i<wordDict.size();i++) {
            Node cur = root;
            String word = wordDict.get(i);
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Node();
                }
                cur = cur.children[index];
            }
            cur.markWordIndex = i;
        }
        return wordBreak(s, wordDict, 0, new List[s.length()], root);
    }

    private List<String> wordBreak(String s, List<String> wordDict, int index, List<String>[] cache, Node root) {
        if (cache[index] != null) return cache[index];

        List<String> list = new ArrayList<>();
        Node cur = root;
        for (int i = index; i < s.length(); ++i) {
            Node node = cur.children[s.charAt(i) - 'a'];
            if (node == null) {
                break;
            } else if (node.markWordIndex >= 0) {
                //found one
                if (i == s.length() - 1) {
                    list.add(wordDict.get(node.markWordIndex));
                } else {
                    for (String subString : wordBreak(s, wordDict, i + 1, cache, root)) {
                        list.add(wordDict.get(node.markWordIndex) + " " + subString);
                    }
                }
            }
            cur = node;
        }
        cache[index] = list;
        return cache[index];
    }

}
