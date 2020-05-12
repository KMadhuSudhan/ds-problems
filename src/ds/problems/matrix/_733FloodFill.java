package ds.problems.matrix;
//https://leetcode.com/problems/flood-fill/
//733. Flood Fill

public class _733FloodFill {

    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {
        _733FloodFill floodFill = new _733FloodFill();
        int[][] matrix = {
                {1,1,1},
                {1,1,0},
                {1,0,1}
        };
        floodFill.floodFill(matrix,1,1,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        if(rows == 0) return image;
        int cols = image[0].length;
        boolean[][] visited = new boolean[rows][cols];
        dfs(image,sr,sc,rows,cols,image[sr][sc],newColor,visited);
        return image;
    }

    void dfs(int[][] image,int row,int col,int rows,int cols,int sourceColor,int newColor,boolean[][] visited) {
        image[row][col] = newColor;
        visited[row][col] = true;
        for(int[] direction: directions) {
            int dx = row + direction[0];
            int dy = col + direction[1];
            if(dx<0 || dy <0 || dx>=rows || dy>= cols || visited[dx][dy] || image[dx][dy]!=sourceColor) {
                continue;
            }
            dfs(image,dx,dy,rows,cols,sourceColor,newColor,visited);
        }
    }
}
