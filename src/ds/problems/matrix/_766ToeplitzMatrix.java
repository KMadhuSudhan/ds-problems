package ds.problems.matrix;
//https://leetcode.com/problems/toeplitz-matrix/
//766. Toeplitz Matrix

public class _766ToeplitzMatrix {

    public boolean isToeplitzMatrix(int[][] matrix) {
        int rows = matrix.length;
        if(rows == 0) return true;
        int cols = matrix[0].length;

        //check top
        int col = 0;

        while(col<cols) {
            int val = matrix[0][col];
            int r = 0;
            int c = col;
            while(r<rows && c < cols) {
                if(val != matrix[r][c]) {
                    return false;
                }
                r++;
                c++;
            }
            col++;
        }
        int row=1;
        while(row<rows) {
            int val = matrix[row][0];
            int r = row;
            int c = 0;
            while(r<rows && c < cols) {
                if(val != matrix[r][c]) {
                    return false;
                }
                r++;
                c++;
            }
            row++;
        }
        return true;
    }
}
