package ds.problems.matrix;
//https://leetcode.com/problems/word-search/
//79. Word Search

public class _79WordSearch {

    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        if(rows == 0) return false;
        int cols = board[0].length;
        char[] chars = word.toCharArray();
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j] == chars[0]) {
                    if(dfs(board,i,j,0,chars)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board,int row,int col,int index,char[] chars) {
        if (index >= chars.length) return true;
        if(row < 0 || col < 0 || row>=board.length || col>= board[0].length) return false;
        if(chars[index] != board[row][col]) return false;
        char tmp = board[row][col];
        board[row][col] = '_';
        boolean result = dfs(board,row+1,col,index+1,chars);
        result = result || dfs(board,row-1,col,index+1,chars);
        result = result || dfs(board,row,col+1,index+1,chars);
        result = result || dfs(board,row,col-1,index+1,chars);
        board[row][col] = tmp;
        return result;
    }
}
