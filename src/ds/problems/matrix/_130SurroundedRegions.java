package ds.problems.matrix;
//https://leetcode.com/problems/surrounded-regions/
//130. Surrounded Regions

public class _130SurroundedRegions {

    public void solve(char[][] board) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == 'O') {
                dfs(board, visited, 0, i);
            }
            if (board[board.length - 1][i] == 'O') {
                dfs(board, visited, board.length - 1, i);
            }
        }

        for (int i = 1; i < board.length; i++) {
            if (board[i][0] == 'O') {
                dfs(board, visited, i, 0);
            }
            if (board[i][board[0].length - 1] == 'O') {
                dfs(board, visited, i, board[0].length - 1);
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }

            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || board[row][col] == 'X') {
            return;
        }
        visited[row][col] = true;
        board[row][col] = '*';
        dfs(board, visited, row + 1, col);
        dfs(board, visited, row - 1, col);
        dfs(board, visited, row, col - 1);
        dfs(board, visited, row, col + 1);
    }
}
