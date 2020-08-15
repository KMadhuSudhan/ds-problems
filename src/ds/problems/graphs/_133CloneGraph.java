package ds.problems.graphs;
//https://leetcode.com/problems/clone-graph/
//133. Clone Graph

import java.util.*;


public class _133CloneGraph {
    Map<Integer, Node> map;

    public Node cloneGraph(Node node) {
        map = new HashMap();
        return dfs(node, map);
    }

    Node dfs(Node node, Map<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node clonedNode = new Node(node.val);
        map.put(node.val, clonedNode);
        if (node.neighbors.size() == 0) {
            return clonedNode;
        }
        for (Node neighbor : node.neighbors) {
            Node neighborCopy = dfs(neighbor, map);
            if (neighborCopy != null) clonedNode.neighbors.add(neighborCopy);
        }
        return clonedNode;
    }

    Node bfs(Node source) {
        if(source == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(source);
        map.put(source,new Node(source.val));

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node currCopy = map.get(curr);
            for(Node neighbor: curr.neighbors) {
                Node newNeighbor = new Node(neighbor.val);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor,newNeighbor);
                    queue.add(neighbor);
                }
                currCopy.neighbors.add(newNeighbor);
            }
        }
        return  map.get(source);
    }


    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
