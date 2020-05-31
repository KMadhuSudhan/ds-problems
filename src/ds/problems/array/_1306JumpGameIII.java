package ds.problems.array;
//https://leetcode.com/problems/jump-game-iii/
//1306. Jump Game III

import java.util.LinkedList;
import java.util.Queue;

public class _1306JumpGameIII {

    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[arr.length];
        while (!queue.isEmpty()) {
            int currIndex = queue.poll();
            if (visited[currIndex]) continue;
            visited[currIndex] = true;
            //forward
            int forward = currIndex + arr[currIndex];
            if (forward < arr.length && arr[forward] == 0) return true;
            if (forward < arr.length) queue.add(forward);

            //backward
            int backward = currIndex - arr[currIndex];
            if (backward >= 0 && arr[backward] == 0) return true;
            if (backward >= 0) queue.add(backward);
        }
        return false;
    }
}
