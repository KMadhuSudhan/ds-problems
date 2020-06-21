package ds.problems.matrix;
//https://leetcode.com/problems/search-a-2d-matrix-ii/
//240. Search a 2D Matrix II

public class _240Searcha2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int j = matrix[0].length-1,i=0;
        while(j>=0) {
            if(i <matrix.length && matrix[i][j] == target) return true;
            if(i <matrix.length && matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
