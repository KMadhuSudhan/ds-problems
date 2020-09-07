package ds.problems.graphs;

public class _1319NumberofOperationstoMakeNetworkConnected {

    class Union {
        int[] parent;
        Union(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        int find(int i) {
            return  parent[i] == i ? i : find(parent[i]);
        }
        void union(int x,int y) {
            int ux = find(x);
            int uy = find(y);
            parent[uy] = ux;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1)  return -1;

        Union un = new Union(n);
        for(int i=0;i<connections.length;i++) {
            un.union(connections[i][0],connections[i][1]);
        }
        int count = 0;

        for(int i = 0; i < n; i++)
        {
            if(i == un.parent[i])
                count++;
        }
        return count - 1;
    }

}
