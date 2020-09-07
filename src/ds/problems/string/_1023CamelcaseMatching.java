package ds.problems.string;
//https://leetcode.com/problems/camelcase-matching/
//1023. Camelcase Matching

import java.util.ArrayList;
import java.util.List;

public class _1023CamelcaseMatching {
    class TrieNode {
        TrieNode[] childrens;
        boolean isEndOfWord;
        TrieNode() {
            this.childrens = new TrieNode[58];
            this.isEndOfWord = false;
        }
    }
    TrieNode root;
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        root = new TrieNode();
        add(pattern);
        List<Boolean> list = new ArrayList();
        for(String word: queries) {
            list.add(match(word));
        }
        return list;
    }
    void add(String word) {
        char[] chars = word.toCharArray();
        TrieNode tmp = root;
        for(int i=0;i<chars.length;i++) {
            int index = chars[i] - 'A';
            if(tmp.childrens[index] == null) {
                tmp.childrens[index] = new TrieNode();
            }
            tmp =  tmp.childrens[index];
        }
        tmp.isEndOfWord = true;
    }
    boolean match(String word) {
        char[] chars = word.toCharArray();
        TrieNode tmp = root;
        for(int i=0;i<chars.length;i++) {
            int index = chars[i] - 'A';
            if(index>=0&&index<26) {
                if(tmp.childrens[index] == null) {
                    return false;
                }
            } else {
                if( tmp.childrens[index] == null) {
                    continue;
                }
            }
            tmp =  tmp.childrens[index];
        }
        return tmp.isEndOfWord;
    }
}
