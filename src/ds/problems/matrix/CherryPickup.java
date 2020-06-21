package ds.problems.matrix;
//https://leetcode.com/problems/cherry-pickup
//741. Cherry Pickup


public class CherryPickup {
    public static void main(String[] args) {
        CherryPickup cherryPickup = new CherryPickup();
        int[][] m = {
                {0, 1, -1},
                {1, 0, -1},
                {1, 1,  1}
        };
        System.out.println(cherryPickup.cherryPickup(m ));
    }
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        if(rows == 0) return 0;
        int cols = grid[0].length;
        int maxOfDownAndRight = dfs(grid,0,0);
        int upAndLeft = dfs1(grid,rows-1,cols-1);
        return maxOfDownAndRight + upAndLeft;
    }

    int dfs(int[][] grid,int row,int col) {
        if(row<0 || col < 0 || row>=grid.length || col >= grid[0].length || grid[row][col] == -1 || grid[row][col] == -2) return 0;
        if(row == grid[0].length && col == grid[0].length-1) {
            return 0;
        }
        int right = grid[row][col] +  dfs(grid,row,col+1);
        int down = grid[row][col] + dfs(grid,row+1,col);
        grid[row][col] = 0;
        grid[row][col] = -2;
        return Math.max(right,down);
    }

    int dfs1(int[][] grid,int row,int col) {
        if(row<0 || col < 0 || row>=grid.length || col >= grid[0].length  || grid[row][col] == -1 || grid[row][col] == -2) return 0;
        if(row == 0 && col == 0) {
            return 0;
        }
        int up = grid[row][col] + dfs1(grid,row-1,col);
        int left = grid[row][col] + dfs1(grid,row,col-1);
        grid[row][col] = 0;
        grid[row][col] = -2;
        return Math.max(up,left);
    }
}
