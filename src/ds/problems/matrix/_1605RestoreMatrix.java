package ds.problems.matrix;
//https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
//1605. Find Valid Matrix Given Row and Column Sums

public class _1605RestoreMatrix {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int x = rowSum.length,y=colSum.length;
        int[][] result = new int[x][y];
        for (int i = 0,j = 0; i < x && j < y;) {
            result[i][j] = Math.min(rowSum[i],colSum[j]);
            rowSum[i] -= result[i][j];
            colSum[j] -= result[i][j];
            if(rowSum[i] == 0) i++;
            if(colSum[j] == 0) j++;
        }
        return result;
    }
}
