package ds.problems.system.design;

import java.util.HashMap;
import java.util.Map;

public class _677MapSumPairs {
    class TrieNode {
        TrieNode[] childrens;
        int prefixSum;
        TrieNode() {
            childrens = new TrieNode[26];
            prefixSum = 0;
        }
    }
    /** Initialize your data structure here. */
    class Trie {

        TrieNode root;
        TrieNode tmp;
        Map<String, Integer> words;

        Trie() {
            root = new TrieNode();
            words = new HashMap<>();
        }

        void insert(String word,int value) {
            char[] chars = word.toCharArray();
            tmp = root;
            boolean containsKey = words.containsKey(word);
            for(int i=0;i<chars.length;i++) {
                int index = chars[i] - 'a';
                if(tmp.childrens[index] == null) {
                    tmp.childrens[index] = new TrieNode();
                }
                tmp = tmp.childrens[index];
                tmp.prefixSum = containsKey ? value : tmp.prefixSum + value;
            }
            words.put(word,value);
        }

        int prefixSum(String word) {
            char[] chars = word.toCharArray();
            tmp = root;
            int sum = 0;
            for(int i=0;i<chars.length;i++) {
                int index = chars[i] - 'a';
                if(tmp.childrens[index] == null) {
                    return 0;
                }
                tmp = tmp.childrens[index];
                sum = tmp.prefixSum;
            }
            return sum;
        }
    }

    Trie trie;
    public _677MapSumPairs() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key,val);
    }

    public int sum(String prefix) {
        return trie.prefixSum(prefix);
    }
}
