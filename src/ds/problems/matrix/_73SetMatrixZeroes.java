package ds.problems.matrix;
//https://leetcode.com/problems/set-matrix-zeroes/
//73. Set Matrix Zeroes

public class _73SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,1,1},
                {1,0,1},
                {1,1,1}
        };
        _73SetMatrixZeroes setMatrixZeroes = new _73SetMatrixZeroes();
        setMatrixZeroes.setZeroes(matrix);
    }
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return;
        int cols = matrix[0].length;
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(matrix[i][j] == 0) {
                    setRowZero(matrix,i,j);
                    setColZero(matrix,i,j);
                }
            }
        }

        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(matrix[i][j] == '*') {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    private void setRowZero(int[][] matrix,int row,int col) {
        for(int i=0;i<matrix[0].length;i++) {
            if(matrix[row][i] == 0 ) continue;
            matrix[row][i] = '*';
        }
    }

    private void setColZero(int[][] matrix,int row,int col) {
        for(int i=0;i<matrix.length;i++) {
            if(matrix[i][col] == 0 ) continue;
            matrix[i][col] = '*';
        }
    }
}
