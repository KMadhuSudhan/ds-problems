package ds.problems.matrix;
//https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
//1252. Cells with Odd Values in a Matrix

public class _1252CellswithOddValuesinamatrix {

    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        int[] rows = new int[n];
        int[] cols = new int[m];
        for(int i=0;i<indices.length;i++) {
            rows[indices[i][0]]+=1;
            cols[indices[i][1]]+=1;
        }
        int count = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                matrix[i][j]+=rows[i];
                matrix[i][j]+=cols[j];
                if(matrix[i][j]%2 == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}
