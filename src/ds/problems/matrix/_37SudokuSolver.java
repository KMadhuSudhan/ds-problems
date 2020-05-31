package ds.problems.matrix;
//https://leetcode.com/problems/sudoku-solver/
//37. Sudoku Solver

public class _37SudokuSolver {
    public static void main(String[] args) {
        _37SudokuSolver sudokuSolver = new _37SudokuSolver();
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
        sudokuSolver.solve(matrix);
    }

    public boolean solve(char[][] board) {
        boolean isEmpty = false;
        int row = -1;
        int col = -1;
        for(int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if(board[i][j] == '.') {
                    isEmpty = true;
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        if (isEmpty == false) {
            return true;
        }
        for (char i='1';i<='9';i++) {
            if (isSafe(board, row, col, i)) {
                board[row][col] = i;
                if(solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.';
                }
            }
        }
        return false;
    }

    boolean isSafe(char[][] board, int row, int col,char num) {
        //same row checking
        for (int i = 0; i < board[0].length; i++) {
            if (board[row][i] == num) return false;
        }

        //same col checking
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) return false;
        }

        //same grid checking
        int grid_size = (int) Math.sqrt(board.length);
        int row_start = row - row % grid_size;
        int col_start = col - col % grid_size;
        int row_end = row_start + grid_size;
        int col_end = col_start + grid_size;
        for (int i = row_start; i < row_end; i++) {
            for (int j = col_start; j < col_end; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
