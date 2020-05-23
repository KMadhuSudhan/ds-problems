package ds.problems.matrix;
//https://leetcode.com/problems/number-of-closed-islands/
//1254. Number of Closed Islands

public class _1254NumberofClosedIslands {
    public static void main(String[] args) {
        _1254NumberofClosedIslands numberofClosedIslands = new _1254NumberofClosedIslands();
        int[][] grid = {
                {0,0,1,0,0},
                {0,1,0,1,0},
                {0,1,1,1,0},
        };
        System.out.println(numberofClosedIslands.closedIsland(grid));
    }

    public int closedIsland(int[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 1; i < grid.length - 1; i++) {
            for (int j = 1; j < grid[0].length - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    if (dfs(grid, i, j, visited)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col] ||  grid[row][col] == 1) {
            return true;
        }
        if (grid[row][col] == 0 && (row == grid.length - 1 || col == grid[0].length)) {
            return false;
        }
        visited[row][col] = true;
        boolean isIsland = true;
        isIsland &= dfs(grid, row + 1, col, visited);
        isIsland &= dfs(grid, row - 1, col, visited);
        isIsland &= dfs(grid, row, col + 1, visited);
        isIsland &= dfs(grid, row, col - 1, visited);
        return isIsland;
    }
}
