package ds.problems.graphs;
//https://leetcode.com/problems/redundant-connection/
//684. Redundant Connection

import java.util.HashMap;

public class _684RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length+1];
        for(int i=0;i<edges.length+1;i++) {
            parent[i] = i;
        }
        for(int[] edge: edges){
            int r1 = find(edge[0], parent);
            int r2 = find(edge[1], parent);
            if(r1 == r2) return edge;
            parent[r2] = r1;
        }
        return edges[0];
    }

    private Integer find(Integer x, int[] parent){
        if(parent[x]!=x) {
            int root = find(parent[x],parent);
            parent[x] = root;
            return root;
        } else {
            return x;
        }
    }
}
