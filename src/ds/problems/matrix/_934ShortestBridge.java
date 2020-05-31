package ds.problems.matrix;
//https://leetcode.com/problems/shortest-bridge/
//934. Shortest Bridge

import java.util.LinkedList;
import java.util.Queue;

public class _934ShortestBridge {

    public int shortestBridge(int[][] A) {
        Queue<int[]> queue = new LinkedList();
        boolean found = false;
        for(int i=0;!found && i<A.length;i++) {
            for(int j=0;!found && j<A.length;j++) {
                if(A[i][j] == 1) {
                    found = true;
                    dfs(A,i,j,queue);
                }
            }
        }
        int steps = 0;
        int[][] directions = new int[][] {
                {1,0},
                {-1,0},
                {0,1},
                {0,-1}
        };

        while(!queue.isEmpty()) {
            int size = queue.size();
            while(size -- > 0) {
                int[] cell =  queue.poll();
                for(int i=0;i<4;i++) {
                    int dx = cell[0] + directions[i][0];
                    int dy = cell[1] + directions[i][1];
                    if(dx < 0 || dy < 0 || dx>=A.length || dy>=A[0].length || A[dx][dy] == 2) {
                        continue;
                    }
                    if(A[dx][dy] == 1) {
                        return steps;
                    }
                    A[dx][dy] = 2;
                    queue.add(new int[]{dx,dy});
                }
            }
            steps++;
        }
        return steps;
    }

    void dfs(int[][] A,int i,int j,Queue<int[]> queue) {
        if(i<0 || j <0 || i >= A.length || j >= A[0].length || A[i][j]!=1) {
            return;
        }
        A[i][j] = 2;
        queue.add(new int[]{i,j});
        dfs(A,i+1,j,queue);
        dfs(A,i-1,j,queue);
        dfs(A,i,j+1,queue);
        dfs(A,i,j-1,queue);
    }
}
