package ds.problems.system.design;
//https://leetcode.com/problems/number-of-recent-calls/
//933. Number of Recent Calls

import java.util.LinkedList;
import java.util.Queue;

public class _333NumberofRecentCalls {

    Queue<Integer> queue;
    public _333NumberofRecentCalls() {
        queue = new LinkedList();
    }

    public int ping(int t) {
        queue.add(t);
        while(!queue.isEmpty() && ((t - queue.peek()) > 3000)) {
            queue.poll();
        }
        return queue.isEmpty() ? null : queue.size();
    }
}
