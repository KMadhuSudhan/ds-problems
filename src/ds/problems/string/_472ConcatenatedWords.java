package ds.problems.string;
//https://leetcode.com/problems/concatenated-words/
//472. Concatenated Words

import java.util.ArrayList;
import java.util.List;

public class _472ConcatenatedWords {

    public static void main(String[] args) {
        System.out.println( "madhu".substring(0,1));
    }
    class TrieNode {
        TrieNode[] childrens;
        boolean isWord;
        TrieNode() {
            childrens = new TrieNode[26];
            isWord = false;
        }
    }
    TrieNode trie;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        trie = new TrieNode();
        for(String word: words) {
            build(word);
        }
        List<String> ans = new ArrayList();
        for(String word: words) {
            if(find(word,0)) {
                ans.add(word);
            }
        }
        return ans;
    }

    void build(String word) {
        TrieNode tmp = trie;
        char[] chars = word.toCharArray();
        for(char c: chars) {
            int index = c - 'a';
            if(tmp.childrens[index] == null) {
                tmp.childrens[index] = new TrieNode();
            }
            tmp =  tmp.childrens[index];
        }
        tmp.isWord = true;
    }
    boolean find(String word,int part) {
        if(word.length() == 0 && part >= 2)
            return true;
        if(word.length() == 0)
            return false;
        TrieNode tmp = trie;
        char[] chars = word.toCharArray();
        for(int i=0;i<chars.length;i++) {
            char c = chars[i];
            int index = c - 'a';
            if(tmp.childrens[index] == null) {
                return false;
            }
            tmp =  tmp.childrens[index];
            if(tmp.isWord) {
                if(find(word.substring(i+1),part+1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
