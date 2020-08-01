package ds.problems.string;
//https://leetcode.com/problems/search-suggestions-system/
//1268. Search Suggestions System

import java.util.*;

public class _1268SearchSuggestionsSystem {
    class TrieNode {
        TrieNode[] childrens;
        List<String> words;
        TrieNode() {
            this.childrens = new TrieNode[26];
            this.words = new ArrayList();
        }
    }

    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        for(String product: products) {
            add(product);
        }
        char[] chars = searchWord.toCharArray();
        List<List<String>> ans = new ArrayList();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<chars.length;i++) {
            sb.append(chars[i]);
            search(sb.toString(),ans);
        }
        return ans;
    }

    void search(String str,List<List<String>> ans) {
        char[] chars = str.toCharArray();
        TrieNode tmp = root;
        List<String> arr = new ArrayList();
        boolean notFound = false;
        for(char c: chars) {
            int index = c - 'a';
            if(tmp.childrens[index] == null) {
                notFound = true;
                break;
            }
            tmp = tmp.childrens[index];
        }
        if(notFound) {
            ans.add(new ArrayList());
        } else {
            List<String> words = tmp.words;
            Collections.sort(words);
            for(int i=0;i<3 && i< words.size();i++) {
                arr.add(words.get(i));
            }
            ans.add(arr);
        }
    }

    void add(String word) {
        TrieNode tmp = root;
        char[] chars = word.toCharArray();
        for(char c: chars) {
            int index = c - 'a';
            if(tmp.childrens[index] == null) {
                tmp.childrens[index] = new TrieNode();
            }
            tmp = tmp.childrens[index];
            tmp.words.add(word);
        }
    }
}
