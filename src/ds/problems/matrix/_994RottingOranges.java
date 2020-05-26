package ds.problems.matrix;
//https://leetcode.com/problems/rotting-oranges/
//994. Rotting Oranges

import java.util.LinkedList;
import java.util.Queue;

public class _994RottingOranges {
    int[][] directions = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
    };

    public static void main(String[] args) {

    }
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList();
        int freshCounts = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    queue.offer(new int[] {i,j});
                } else if (grid[i][j] == 1) {
                    freshCounts++;
                }
            }
        }

        int count = 0;
        while(!queue.isEmpty() && freshCounts > 0) {
            count++;
            int size = queue.size();
            while (size-- > 0) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for(int[] direction: directions) {
                    int dx = x + direction[0];
                    int dy = y + direction[1];
                    if(dx < 0 || dy < 0 || dx>=grid.length || dy>= grid[0].length || grid[dx][dy]!=1) {
                        continue;
                    }
                    grid[dx][dy] = 2;
                    freshCounts--;
                    queue.add(new int[]{dx,dy});
                }
            }
        }
        return freshCounts == 0 ? count : -1;
    }
}
