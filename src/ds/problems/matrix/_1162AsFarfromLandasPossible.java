package ds.problems.matrix;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/as-far-from-land-as-possible/
//https://leetcode.com/problems/as-far-from-land-as-possible/
public class _1162AsFarfromLandasPossible {
    public static void main(String[] args) {
        _1162AsFarfromLandasPossible asFarfromLandasPossible = new _1162AsFarfromLandasPossible();
        int[][] matrix = {
                {1,0,1},
                {0,0,0},
                {1,0,1}
        };
        asFarfromLandasPossible.maxDistance(matrix);
    }
    public int maxDistance(int[][] grid) {
        if(grid.length == 0) return 0;
        int steps = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {
                    queue.add(new int[]{i+1,j});
                    queue.add(new int[]{i-1,j});
                    queue.add(new int[]{i,j-1});
                    queue.add(new int[]{i,j+1});
                }
            }
        }
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for(int i=0;i<size;i++) {
                int[] front = queue.poll();
                int r = front[0];
                int c = front[1];
                if(r>=0 && c >=0 && r<grid.length && c < grid[0].length && grid[r][c] == 0) {
                    grid[r][c] = steps;
                    queue.add(new int[]{r+1,c});
                    queue.add(new int[]{r-1,c});
                    queue.add(new int[]{r,c - 1});
                    queue.add(new int[]{r,c + 1});
                }
            }
        }
        return steps == 1 ? -1 : steps-1;
    }
}
