package ds.problems.matrix;
//https://leetcode.com/problems/valid-sudoku/
//36. Valid Sudoku

public class _36ValidSudoku {
    public static void main(String[] args) {
        _36ValidSudoku validSudoku = new _36ValidSudoku();
        char[][] matrix = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.println(validSudoku.isValidSudoku(matrix));
    }
    public boolean isValidSudoku(char[][] board) {
        int rows = board.length,cols = board.length;
        boolean[] visited = new boolean[board[0].length];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if(board[i][j] == '.') continue;
                if(validateRow(board,i,cols) && validateCol(board,j,rows,visited) && validateGrid(board,i,j)) {
                    visited[j] = true;
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    boolean validateRow(char[][] board,int row,int cols) {
        int[] nums = new int[9];
        for(int i=0;i<cols;i++) {
            if( board[row][i] == '.') continue;
            int val = board[row][i] - '0' -1;
            if(board[row][i]>='1' && board[row][i]<='9' && nums[val] == 0) {
                nums[val] = 1;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean validateCol(char[][] board,int col,int rows,boolean[] visited) {
        if(visited[col]) return true;
        int[] nums = new int[9];
        for(int i=0;i<rows;i++) {
            if(board[i][col] == '.') continue;
            int val = board[i][col] - 1 -'0';
            if(board[i][col]>='1' && board[i][col]<='9' && nums[val] == 0) {
                nums[val] = 1;
            } else {
                return false;
            }
        }
        return true;
    }

    boolean validateGrid(char[][] board,int row,int col) {
        int startRow = row - row%3;
        int startCol = col - col%3;
        int endRow = row + (3 - row%3-1);
        int endCol = col + (3 - col%3-1);
        int[] nums = new int[9];
        for(int i=startRow;i<=endRow;i++) {
            for(int j=startCol;j<=endCol;j++) {
                if(board[i][j] == '.') continue;
                int val = board[i][j] - 1 -'0';
                if(board[i][j]>='1' && board[i][j]<='9' && nums[val] == 0) {
                    nums[val] = 1;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
