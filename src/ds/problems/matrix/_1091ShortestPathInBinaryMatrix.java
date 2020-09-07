package ds.problems.matrix;
//https://leetcode.com/problems/shortest-path-in-binary-matrix/
//1091. Shortest Path in Binary Matrix

import java.util.LinkedList;
import java.util.Queue;

public class _1091ShortestPathInBinaryMatrix {

    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int count = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1) return -1;
        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{0,0});
        grid[0][0] = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1];
                if(row == rows-1 && col == cols-1) return count+1;
                for(int[] direction: directions) {
                    int dx = row  + direction[0];
                    int dy = col + direction[1];
                    if(dx < 0 || dy < 0 || dx>=rows || dy>= cols || grid[dx][dy] == 1) {
                        continue;
                    }
                    queue.add(new int[]{dx,dy});
                    grid[dx][dy] = 1;
                }
            }
            count++;
        }
        return -1;
    }
}
