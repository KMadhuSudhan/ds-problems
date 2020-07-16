package ds.problems.matrix;
//https://leetcode.com/problems/word-search-ii/
//212. Word Search II

import java.util.ArrayList;
import java.util.List;

public class _212WordSearchII {

    TrieNode root;
    int m, n;
    class TrieNode {
        TrieNode[] children;
        boolean isWord;
        String s;
        TrieNode() {
            children = new TrieNode[26];
            isWord = false;
            s = null;
        }
    }

    List<String> ans;
    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        List<String> res = new ArrayList<>();
        if(board == null || m == 0 || words == null || words.length == 0) return res;

        n = board[0].length;
        root = new TrieNode();
        for(String word: words) insert(word);

        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                dfs(board, visited, root, res, i, j);
            }
        }
        return res;
    }

    private void dfs(char[][] board, boolean[][] visited, TrieNode cur, List<String> res, int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || cur.children[board[x][y] - 'a'] == null) return;
        visited[x][y] = true;
        cur = cur.children[board[x][y] - 'a'];
        if(cur.isWord) {
            res.add(cur.s);
            cur.isWord = false;
            cur.s = null;
        }
        dfs(board, visited, cur, res, x + 1, y);
        dfs(board, visited, cur, res, x - 1, y);
        dfs(board, visited, cur, res, x, y + 1);
        dfs(board, visited, cur, res, x, y - 1);
        visited[x][y] = false;
    }

    private void insert(String word) {
        TrieNode cur = root;
        for(char c: word.toCharArray()) {
            if(cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
        cur.s = word;
    }
}
