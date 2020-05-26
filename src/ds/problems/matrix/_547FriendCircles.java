package ds.problems.matrix;
//https://leetcode.com/problems/friend-circles/
//547. Friend Circles

public class _547FriendCircles {

    public int findCircleNum(int[][] M) {
        int length = M.length;
        if(length == 0) return 0;
        boolean[] visited = new boolean[length];
        int count =0;
        for(int i=0;i<length;i++){
            if(!visited[i]) {
                dfs(M, visited, i,length);
                count++;
            }
        }
        return count;
    }

    void dfs(int[][] grid,boolean[] visited, int i,int length) {
        for(int j=0;j<length;j++) {
            if(grid[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(grid,visited,j,length);
            }
        }
    }
}
