package ds.problems.matrix;
//https://leetcode.com/problems/word-search-ii/
//212. Word Search II

import java.util.ArrayList;
import java.util.List;

public class _212WordSearchII {

    class Trie {
        TrieNode root;
        TrieNode temp;

        Trie() {
            root = new TrieNode();
        }
        void insert(String word) {
            char[] chars = word.toCharArray();
            temp = root;
            for(int i=0;i<chars.length;i++) {
                if(temp.childs[chars[i] - 'a'] == null) {
                    temp.childs[chars[i] - 'a'] = new TrieNode();
                }
                temp = temp.childs[chars[i] - 'a'];
            }
            temp.isEndOfWord = true;
        }

        boolean[] isPrefix(String word) {
            char[] chars = word.toCharArray();
            temp = root;
            for(int i=0;i<chars.length;i++) {
                if(temp.childs[chars[i] - 'a'] != null) {
                    temp = temp.childs[chars[i] - 'a'];
                } else {
                    return new boolean[] {false,false};
                }
            }
           return new boolean[] {true,temp.isEndOfWord};
        }
    }

    class TrieNode {
        TrieNode[] childs;
        boolean isEndOfWord;
        public TrieNode() {
            childs = new TrieNode[26];
            isEndOfWord = false;
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i=0;i<words.length;i++) {
            trie.insert(words[i]);
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if(trie.root.childs[board[i][j] - 'a']!=null)  {
                    boolean[][] visited = new boolean[i][j];
                    dfs(board,i,j,String.valueOf(board[i][j]),trie,ans,visited);
                }
            }
        }
        return ans;
    }

    void dfs(char[][] board,int row,int col,String word,Trie trie,List<String> ans,boolean[][] visited) {
        if(row<0 || col < 0 || row>=board.length || col>=board[0].length) return;
        boolean[] res = trie.isPrefix(word);
        if(!res[0]) return;
        if(res[1])  ans.add(word);
        visited[row][col] = true;
        for (int[] neigh : neighbors(board, row, col)) {
            if (!visited[neigh[0]][neigh[1]]) {
                dfs(board,neigh[0], neigh[1],word +  String.valueOf(board[neigh[0]][neigh[1]]),trie,ans,visited);
            }
        }
    }

    public List<int[]> neighbors (char[][] board, int row, int col) {
        int rows = board.length; int cols = board[0].length;
        List<int[]> list = new ArrayList<>();
        if (row-1 >= 0) list.add(new int[]{row-1, col});
        if (col-1 >= 0) list.add(new int[]{row, col-1});
        if (col+1 < cols) list.add(new int[]{row, col+1});
        if (row+1 < rows) list.add(new int[]{row+1, col});
        return list;
    }
}
