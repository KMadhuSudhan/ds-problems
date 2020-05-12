package ds.problems.matrix;
//https://leetcode.com/problems/unique-paths-ii/
//63. Unique Paths II

public class _63UniquePathsII {
    public static void main(String[] args) {
        _63UniquePathsII uniquePathsII = new _63UniquePathsII();
//        int[][] matrix = {
//                {0, 0, 0},
//                {0, 1, 0},
//                {0, 0, 0}
//        };
        int[][] matrix = {
                {1,0}
        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(matrix));
    }

    public int uniquePathsWithObstacles(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) return 0;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
               if(grid[i][j] == 1) {
                   grid[i][j] = 0;
               } else {
                   grid[i][j] +=  i>0 ? grid[i-1][j] : 0;
                   grid[i][j] +=  j>0 ? grid[i][j-1] : 0;
               }
            }
        }
        return grid[rows - 1][cols - 1];
    }
}
