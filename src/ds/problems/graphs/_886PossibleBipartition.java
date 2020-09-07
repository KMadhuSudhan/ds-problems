package ds.problems.graphs;
//https://leetcode.com/problems/possible-bipartition/
//886. Possible Bipartition

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _886PossibleBipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] colors = new int[N];
        List<Integer>[]  graph = constructGraph(dislikes,N);
        for(int i=0;i<N;i++) {
            if(colors[i] == 0 &&!bfs(i,colors,graph)) {
                return false;
            }
        }
        return true;
    }
    boolean bfs(int source,int[] colors,List<Integer>[] graph) {
        colors[source] = 1;
        Queue<Integer> queue = new LinkedList();
        queue.add(source);
        while(!queue.isEmpty()) {
            int u = queue.poll();
            for(int v : graph[u]) {
                if(colors[v] == 0) {
                    colors[v] = -colors[u];
                    queue.add(v);
                } else {
                    if(colors[v] == colors[u]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    List<Integer>[] constructGraph(int[][] dislikes, int N) {
        List<Integer>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++) {
            graph[i] = new ArrayList();
        }
        for(int i=0;i<dislikes.length;i++) {
            int u = dislikes[i][0]-1;
            int v = dislikes[i][1]-1;
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }
}
