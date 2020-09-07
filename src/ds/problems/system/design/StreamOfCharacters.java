package ds.problems.system.design;
//https://leetcode.com/problems/stream-of-characters/
//1032. Stream of Characters

import java.util.ArrayList;
import java.util.List;

public class StreamOfCharacters {
    Node root;
    List<Character> queries;
    class Node {
        Node[] childrens;
        boolean isWord;
        Node() {
            childrens = new Node[26];
            isWord = false;
        }
        void add(String word) {
            Node tmp = root;
            char[] chars = word.toCharArray();
            for(int i=chars.length-1;i>=0;i--) {
                int index = chars[i] - 'a';
                if(tmp.childrens[index] == null) {
                    tmp.childrens[index] = new Node();
                }
                tmp =  tmp.childrens[index];
            }
            tmp.isWord = true;
        }

        boolean search(List<Character> list) {
            Node tmp = root;
            for(int i=list.size()-1;i>=0;i--) {
                int index = list.get(i) - 'a';
                if(tmp.childrens[index] == null) {
                    break;
                }
                tmp =  tmp.childrens[index];
                if(tmp.isWord) return true;
            }
            return tmp.isWord;
        }
    }
    public StreamOfCharacters(String[] words) {
        root = new Node();
        for(String word: words) {
            root.add(word);
        }
        queries = new ArrayList();
    }

    public boolean query(char letter) {
        queries.add(letter);
        return root.search(queries);
    }
}
