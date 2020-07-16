package ds.problems.system.design;
//https://leetcode.com/problems/implement-magic-dictionary/
//676. Implement Magic Dictionary

public class MagicDictionary {
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

            for (int i = 0; i < chars.length; i++) {
                int index = chars[i] - 'a';
                if (tmp.childrens[index] == null) {
                    tmp.childrens[index] = new TrieNode();
                }
                tmp = tmp.childrens[index];
            }
            tmp.isEndOfWord = true;
        }

        boolean search(String word) {
            tmp = root;
            char[] chars = word.toCharArray();
            for(char character: chars) {
                int index = character - 'a';
                if(tmp.childrens[index] == null) {
                    return false;
                }
                tmp = tmp.childrens[index];
            }
            return tmp.isEndOfWord;
        }

    }

    Trie trie;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        trie = new Trie();
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            trie.addWord(word);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++) {
            char ch = chars[i];
            for(char letter = 'a'; letter <= 'z'; letter++) {
                if(letter == chars[i]) continue;
                chars[i] = letter;
                if(trie.search(new String(chars))) {
                    return true;
                }
                chars[i] = ch;
            }
        }
        return false;
    }
}
