package ds.problems.graphs;
//https://leetcode.com/problems/is-graph-bipartite/
//785. Is Graph Bipartite?

import java.util.LinkedList;
import java.util.Queue;

public class _785IsGraphBipartite {

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0;i<graph.length;i++) {
            if(color[i] == 0 && !isBiparate(graph,i,color)) return false;
        }
        return true;
    }

    boolean isBiparate(int[][] graph,int source,int[] color) {
        color[source] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for(int v: graph[u]) {
                if(color[v] == 0) {
                    color[v] = -1 * color[u];
                    queue.add(v);
                } else if(color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
