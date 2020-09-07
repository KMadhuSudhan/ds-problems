package ds.problems.matrix;
//https://leetcode.com/problems/escape-a-large-maze/
//1036. Escape a Large Maze

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class _1036EscapeALargeMaze {

    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length == 0 || source[0] == target[0] && source[1] == target[1]) return true;
        Set<Integer> set = new HashSet();
        for (int[] cell : blocked) {
            if (cell[0] == source[0] && cell[1] == source[1]) return false;
            if (cell[0] == target[0] && cell[1] == target[1]) return false;
            set.add(cell[0] * 1000000 + cell[1]);
        }

        boolean sourceCanPass = bfs(source, target, set);
        if (!sourceCanPass) return false;
        boolean targetCanPass = bfs(target, source, set);
        return targetCanPass;
    }

    boolean bfs(int[] source, int[] target, Set<Integer> set) {
        Set<Integer> visited = new HashSet();
        Queue<int[]> q = new LinkedList();
        int pos = source[0] * 1000000 + source[1];
        q.add(source);
        visited.add(pos);
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            if (cell[0] == target[0] && cell[1] == target[1]) return true;
            for (int[] direction : directions) {
                int x = cell[0] + direction[0];
                int y = cell[1] + direction[1];
                if (x < 0 || y < 0 || x >= 1000000 || y >= 1000000) continue;
                pos = x * 1000000 + y;
                if (set.contains(pos) || visited.contains(pos)) continue;
                q.offer(new int[]{x, y});
                visited.add(pos);
            }
            if (q.size() > set.size()) return true;
        }
        return false;
    }
}
