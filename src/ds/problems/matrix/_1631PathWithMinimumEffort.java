package ds.problems.matrix;
//https://leetcode.com/problems/path-with-minimum-effort/
//1631. Path With Minimum Effort

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class _1631PathWithMinimumEffort {
    class Node {
        int diff;
        int x;
        int y;
        public Node(int diff,int x,int y) {
            this.diff = diff;
            this.x = x;
            this.y = y;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] directions = new int[][]{
                {1,0},{-1,0},{0,-1},{0,1}
        };
        int[][] diff = new int[heights.length][heights[0].length];

        for(int[] r: diff) {
            Arrays.fill(r,Integer.MAX_VALUE);
        }
        diff[0][0] = 0;
        Queue<Node> queue =  new PriorityQueue<Node>((a, b) -> a.diff - b.diff);
        queue.add(new Node(0,0,0));
        boolean[][] visited = new boolean[rows][cols];
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.x == rows - 1 && cur.y == cols-1) {
                return cur.diff;
            }
            visited[cur.x][cur.y] = true;
            for(int[] direction: directions) {
                int dx = cur.x + direction[0];
                int dy = cur.y + direction[1];
                if(dx>=rows || dy>=cols || dy < 0 || dx < 0 || visited[dx][dy]) continue;
                int absDiff = Math.abs(heights[cur.x][cur.y] - heights[dx][dy]);
                int maxDiff = Math.max(absDiff, diff[cur.x][cur.y]);

                if(diff[dx][dy] > maxDiff) {
                    diff[dx][dy] = maxDiff;
                    queue.add(new Node(maxDiff,dx,dy));
                }
            }
        }
        return diff[rows - 1][cols - 1];
    }
}
