package ds.problems.matrix;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/
//1277. Count Square Submatrices with All Ones

public class _1277CountSquareSubmatriceswithAllOnes {
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        for(int i=1;i<=matrix.length;i++) {
            for(int j=1;j<=matrix[0].length;j++) {
                if(matrix[i-1][j-1] == 1) {
                    int max = Math.min(dp[i-1][j-1],dp[i-1][j]);
                    dp[i][j] = 1 + Math.min(max,dp[i][j-1]);
                    ans+=dp[i][j];
                }
            }
        }
        return ans;
    }
}
