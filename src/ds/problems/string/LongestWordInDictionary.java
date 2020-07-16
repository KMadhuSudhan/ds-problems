package ds.problems.string;
//https://leetcode.com/problems/longest-word-in-dictionary/
//720. Longest Word in Dictionary

import java.util.Arrays;
import java.util.Comparator;

public class LongestWordInDictionary {
    public static void main() {

    }
    class TrieNode {
        TrieNode[] childrens;
        boolean isEndOfWord;
        TrieNode() {
            this.childrens = new TrieNode[26];
            this.isEndOfWord = false;
        }
    }

    class Trie {
        TrieNode root;
        TrieNode tmp;
        Trie() {
            this.root = new TrieNode();
        }
        void addWord(String word) {
            tmp = root;
            char[] chars = word.toCharArray();

            for(int i=0;i<chars.length;i++) {
                int index = chars[i] - 'a';
                if(tmp.childrens[index] == null) {
                    tmp.childrens[index] = new TrieNode();
                }
                tmp = tmp.childrens[index];
            }
            tmp.isEndOfWord = true;
        }

        boolean search(String word) {
            tmp = root;
            char[] chars = word.toCharArray();
            for(int i=0;i<chars.length-1;i++) {
                int index = chars[i] - 'a';
                if(tmp.childrens[index] == null) {
                    return false;
                }
                tmp = tmp.childrens[index];
                if(tmp.isEndOfWord == false) return false;
            }
            return tmp.isEndOfWord;
        }
    }
    Trie trie;

    public String longestWord(String[] words) {
        String ans = "";
        trie = new Trie();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        for(String word: words) {
            boolean found = trie.search(word);
            if(found && ans.length() <=  word.length()) {
                if(ans.length() == word.length()) {
                    if(word.compareTo(ans) < 0) {
                        ans = word;
                    }
                } else {
                    ans = word;
                }
            } else if(word.length() == 1) {
                if(ans.length() == 0) {
                    ans = word;
                }
                else if(word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
            trie.addWord(word);
        }
        return ans;
    }
}
