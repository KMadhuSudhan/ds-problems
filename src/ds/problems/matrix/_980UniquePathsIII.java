package ds.problems.matrix;
//https://leetcode.com/problems/unique-paths-iii/
//980. Unique Paths III

public class _980UniquePathsIII {
    int ans = 0;
    public static void main(String[] args) {
        _980UniquePathsIII uniquePathsIII = new _980UniquePathsIII();
        int[][] matrix = {
                {1,0,0,0},
                {0,0,0,0},
                {0,0,2,-1}
        };
        uniquePathsIII.uniquePathsIII(matrix);
    }
    public int uniquePathsIII(int[][] grid) {
        int rows = grid.length;
        if(rows ==0) return 0;
        int cols = grid[0].length;
        int row = 0,col=0,total_zeros=0;
        boolean[][] visited = new boolean[rows][cols];
        for(int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(grid[i][j] == 1) {
                    row = i;
                    col = j;
                }
                if(grid[i][j] == 0) {
                    total_zeros++;
                }
            }
        }
        dfs(grid,row,col,0,total_zeros,visited);
        return ans;
    }

    void dfs(int[][] grid,int row,int col,int current_zeros,int total_zeros,boolean[][] visited) {
        if(row <0 || col <0 || row>=grid.length || col>= grid[0].length ||  visited[row][col] || grid[row][col] == -1) {
            return;
        }
        visited[row][col] = true;
        if(grid[row][col] == 0) current_zeros++;
        if(grid[row][col] == 2){
            if(current_zeros == total_zeros) ans++;
            visited[row][col] = false;
            return;
        }
        dfs(grid,row+1,col,current_zeros,total_zeros,visited);
        dfs(grid,row-1,col,current_zeros,total_zeros,visited);
        dfs(grid,row,col+1,current_zeros,total_zeros,visited);
        dfs(grid,row,col-1,current_zeros,total_zeros,visited);
        visited[row][col] = false;
    }
}
