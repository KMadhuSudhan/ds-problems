package ds.problems.matrix;
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//329. Longest Increasing Path in a Matrix

public class _329LongestIncreasingPathInAMatrix {

    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 ) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++) {
                max = Math.max(max,dfs(matrix,dp,i,j));
            }
        }
        return max;
    }

    int dfs(int[][] matrix,int[][] dp,int row,int col) {
        if(dp[row][col] == 0) {
            int max = 1;
            for(int[] direction: directions) {
                int dx = row + direction[0];
                int dy = col + direction[1];
                if(dx < 0 || dy < 0 || dx>=matrix.length || dy>= matrix[0].length || matrix[dx][dy] <= matrix[row][col]) {
                    continue;
                }
                max = Math.max(max, 1 + dfs(matrix, dp, dx, dy));
            }
            dp[row][col] = max;
        }
        return dp[row][col];
    }
}
