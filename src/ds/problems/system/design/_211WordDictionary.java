package ds.problems.system.design;

public class _211WordDictionary {
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
            return search(word,0,tmp);
        }

        private boolean search(String word, int indx, TrieNode curr) {
            if(curr == null)
                return false;
            if(curr.isEndOfWord) {
                if(indx == word.length())
                    return true;
            }
            if(indx == word.length())
                return false;

            if(word.charAt(indx) == '.') {
                for(int i = 0; i < 26; i++) {
                    if(curr.childrens[i] != null) {
                        if(search(word, indx + 1, curr.childrens[i]) == true)
                            return true;
                    }
                }
            } else {
                int i = word.charAt(indx) - 'a';
                boolean present = search(word, indx + 1, curr.childrens[i]);
                if(present)
                    return true;
            }
            return false;
        }
    }
    Trie trie;

    /** Initialize your data structure here. */
    public _211WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.addWord(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word);
    }
}
