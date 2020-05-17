package ds.problems.matrix;
//https://leetcode.com/problems/count-servers-that-communicate/
//1267. Count Servers that Communicate

public class _1267CountServersThatCommunicate {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0},
                {0, 1}
        };
        _1267CountServersThatCommunicate countServersThatCommunicate = new _1267CountServersThatCommunicate();
        countServersThatCommunicate.countServers(matrix);
    }

    public int countServers(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && (checkRow(grid, i, j) || checkColumn(grid, i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    boolean checkRow(int[][] grid, int row, int column) {
        for (int i = 0; i < grid[0].length; i++) {
            if (i != column && grid[row][i] == 1) return true;
        }
        return false;
    }

    boolean checkColumn(int[][] grid, int row, int column) {
        for (int i = 0; i < grid.length; i++) {
            if (i != row && grid[i][column] == 1) return true;
        }
        return false;
    }
}
