package ds.problems.matrix;
//https://leetcode.com/problems/sudoku-solver/
//37. Sudoku Solver

public class _37SudokuSolver {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        int[][] rowMap = new int[9][9];
        int[][] colMap = new int[9][9];
        int[][] gridMap = new int[9][9];
        for (int i=0;i<9;i++) {
            for (int j=0;j<9;j++) {
                int val = board[i][j] - '0' - 1;
                rowMap[i][val] = 1;
                colMap[j][val] = 1;
                if(i<2 && j <2) {
                    gridMap[0][val] = 1;
                }
            }
        }
    }
}
