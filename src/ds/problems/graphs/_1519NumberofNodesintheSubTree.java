package ds.problems.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1519NumberofNodesintheSubTree {
    int [] ans;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        Map<Integer,List<Integer>> graph = new HashMap();
        ans = new int[n];
        for(int i=0;i<n;i++) {
            graph.put(i,new ArrayList());
        }
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int[] count = new int[26];
        dfs(graph,0,visited,count,labels);
        return ans;
    }
    void dfs(Map<Integer,List<Integer>> graph,int current,boolean[] visited,int[] count,String labels) {
        if(visited[current]){
            return;
        }
        visited[current] = true;
        for(Integer neighbour: graph.get(current)) {
            if(!visited[neighbour]) {
                int[] tmp = new int[26];
                dfs(graph,neighbour,visited,tmp,labels);
                for(int i = 0 ; i < 26 ; i++){
                    count[i] += tmp[i];
                }
            }
        }
        count[labels.charAt(current) - 'a']++;
        ans[current] = count[labels.charAt(current)-'a'];
    }
}
