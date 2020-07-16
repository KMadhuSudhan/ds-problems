package ds.problems.system.design;
//https://leetcode.com/problems/replace-words/
//648. Replace Words

import java.util.ArrayList;
import java.util.List;

public class _648ReplaceWords {

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
            root = new TrieNode();
        }

        public void addWord(String word) {
            tmp = root;
            char[] charcters = word.toCharArray();
            for (int i = 0; i < charcters.length; i++) {
                int index = charcters[i] - 'a';
                if (tmp.childrens[index] == null) {
                    tmp.childrens[index] = new TrieNode();
                }
                tmp = tmp.childrens[index];
            }
            tmp.isEndOfWord = true;
        }

        public String search(String word) {
            tmp = root;
            char[] characters = word.toCharArray();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < characters.length; i++) {
                int index = characters[i] - 'a';
                if (tmp.isEndOfWord) return sb.toString();
                if (tmp.childrens[index] == null) {
                    return word;
                }
                sb.append(characters[i]);
                tmp = tmp.childrens[index];
            }
            return word;
        }
    }

    public static void main(String[] args) {
        _648ReplaceWords replaceWords = new _648ReplaceWords();
        List<String> words = new ArrayList<>();
        words.add("cat");
        words.add("bat");
        words.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords.replaceWords(words, sentence));
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie trie = new Trie();
        for (String word : dict) {
            trie.addWord(word);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length-1; i++) {
            String word = words[i];
            sb.append(trie.search(word));
            sb.append(" ");
        }
        sb.append(trie.search(words[words.length-1]));
        return sb.toString();
    }
}
