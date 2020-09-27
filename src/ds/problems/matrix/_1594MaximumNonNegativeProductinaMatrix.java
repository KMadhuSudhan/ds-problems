package ds.problems.matrix;
//https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
//1594. Maximum Non Negative Product in a Matrix

public class _1594MaximumNonNegativeProductinaMatrix {
    public int maxProductPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int mod = 1000000007;
        long[][] pdp = new long[rows][cols];
        long[][] ndp = new long[rows][cols];
        pdp[0][0] = grid[0][0];
        ndp[0][0] = grid[0][0];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                if (i == 0 && j == 0) {
                    continue;
                }
                if(i==0) {
                    pdp[i][j] = (long) grid[i][j] * pdp[i][j - 1];
                    ndp[i][j] = pdp[i][j];
                } else if(j == 0) {
                    pdp[i][j] = (long) grid[i][j] * pdp[i - 1][j];
                    ndp[i][j] = pdp[i][j];
                } else {
                    long product0 = (long) grid[i][j] * Math.max(pdp[i - 1][j], pdp[i][j - 1]);
                    long product1 = (long) grid[i][j] * Math.min(ndp[i - 1][j], ndp[i][j - 1]);
                    pdp[i][j] = Math.max(product0, product1);
                    ndp[i][j] = Math.min(product0, product1);
                }
            }
        }
        return pdp[rows-1][cols - 1] >= 0 ? (int) (pdp[rows - 1][cols - 1] % mod) : -1;
    }
}
