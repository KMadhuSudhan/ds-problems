package ds.problems.graphs;
//743. Network Delay Time
//https://leetcode.com/problems/network-delay-time/

import java.util.*;

public class _743NetworkDelayTime {
    public static void main(String[] args) {
        _743NetworkDelayTime networkDelayTime = new _743NetworkDelayTime();
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        networkDelayTime.networkDelayTime(times, 4, 2);
    }


    public int networkDelayTime(int[][] times, int N, int K) {
        Map<Integer, List<Node>> graph = new HashMap<>();

        for (int i = 1; i <= N; i++)
            graph.put(i, new ArrayList<>());

        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new Node(times[i][1], times[i][2]));
        }

        Set<Integer> visited = new HashSet<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        dijkstra(K, graph, visited, distance);

        if (N != visited.size()) return -1;

        int max = distance[1];

        for (int i = 1; i < distance.length; i++)
            max = Math.max(max, distance[i]);

        return max;
    }

    public void dijkstra(int src, Map<Integer, List<Node>> graph, Set<Integer> visited, int[] distance) {
        PriorityQueue<Node> q = new PriorityQueue<>();
        distance[src] = 0;
        q.add(new Node(src, 0));

        while (!q.isEmpty()) {

            Node parent = q.poll();
            visited.add(parent.adj);

            List<Node> adjacent = graph.get(parent.adj);

            for (int i = 0; i < adjacent.size(); i++) {
                Node child = adjacent.get(i);
                int v = child.adj;
                int cst = child.cost;
                if (!visited.contains(v)) {
                    if (distance[v] > distance[parent.adj] + cst) {
                        distance[v] = distance[parent.adj] + cst;
                        q.add(new Node(v, distance[v]));
                    }
                }
            }

        }
    }

    class Node implements Comparable<Node> {
        int adj;
        int cost;

        Node(int adj, int cost) {
            this.adj = adj;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
