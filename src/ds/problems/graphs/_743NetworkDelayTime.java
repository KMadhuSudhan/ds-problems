package ds.problems.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _743NetworkDelayTime {
    public static void main(String[] args) {
        _743NetworkDelayTime networkDelayTime = new _743NetworkDelayTime();
        int[][] times = {
                {2,1,1},
                {2,3,1},
                {3,4,1}
        };
        networkDelayTime.networkDelayTime(times,4,2);
    }
    int ans = 0;
    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer,List<int[]>> graph = new HashMap<>();
        for(int i=0;i<=times.length;i++) {
            graph.put(i,new ArrayList<>());
        }
        for(int[] time: times) {
            int[] sourceToDestination = new int[]{time[1],time[2]};
            List<int[]> sourceList = graph.get(time[0]);
            sourceList.add(sourceToDestination);
            graph.put(time[0],sourceList);

            int[] DestinationToSource = new int[]{time[0],time[2]};
            List<int[]> destinationList = graph.get(time[1]);
            destinationList.add(DestinationToSource);
            graph.put(time[1],destinationList);
        }
        boolean[] visited = new boolean[N];
        dfs(graph,K,visited);
        return ans;
    }
    void dfs(Map<Integer,List<int[]>> graph,int node,boolean[] visited) {
        for(int[] neighbour: graph.get(node)) {
            if(visited[neighbour[0]]) continue;
            ans+= neighbour[3];
            visited[neighbour[0]] = true;
            dfs(graph,neighbour[0],visited);
        }
    }
}
