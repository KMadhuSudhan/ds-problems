package ds.problems.matrix;
//https://leetcode.com/problems/minimum-path-sum/
//64. Minimum Path Sum

public class _64MinimumPathSum {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,5},
                {3,2,1}
        };
        _64MinimumPathSum minimumPathSum = new _64MinimumPathSum();
        System.out.println(minimumPathSum.minPathSum(matrix));
    }
    public int minPathSum(int[][] grid) {
        int rows = grid.length,cols = grid[0].length;
        for (int i=1;i<rows;i++) {
            grid[i][0] = grid[i][0]  +  grid[i-1][0];
        }

        for (int i=1;i<cols;i++) {
            grid[0][i] = grid[0][i] + grid[0][i-1];
        }
        for(int i=1;i<rows;i++) {
            for (int j=1;j<cols;j++) {
                grid[i][j] +=  Math.min(grid[i][j-1],grid[i-1][j]);
            }
        }
        return grid[rows-1][cols-1];
     }
}
