package ds.problems.graphs;
//https://leetcode.com/problems/redundant-connection-ii/
//685. Redundant Connection II

public class _685RedundantConnectionII {

    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] visited=new int[edges.length+1];
        int parent[]=new int[edges.length+1];
        int cycle1[]=null;
        int cycle2[]=null;

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            if(visited[v] > 0){
                cycle1=new int[]{visited[v],v};
                cycle2=edge;
            }
            visited[v]=u;

        }

        for(int[] edge:edges){

            if(cycle2 == edge) continue;

            int u=edge[0];
            int v=edge[1];

            int parentOf_u=findParent(u,parent);
            int parentOf_v=findParent(v,parent);

            if(parentOf_u == parentOf_v){
                return (cycle1 == null)?edge:cycle1;
            }
            parent[parentOf_v]=parentOf_u;
        }
        return cycle2;
    }
    public int findParent(int idx,int []parent){
        if(parent[idx] == 0)
            parent[idx]=idx;
        if(parent[idx] != idx)
            parent[idx]=findParent(parent[idx],parent);
        return parent[idx];
    }
}
