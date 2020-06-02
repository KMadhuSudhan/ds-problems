package ds.problems.graphs;
//https://leetcode.com/problems/evaluate-division/
//399. Evaluate Division

import java.util.*;

public class _399EvaluateDivision {

    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Map<String,Double>> graph = buildGraph(equations,values);
        double[] ans = new double[queries.size()];

        for(int i=0;i<queries.size();i++) {
            ans[i] = getPathWeight(graph,queries.get(i).get(0),queries.get(i).get(1),new HashSet<>());
        }
        return ans;
    }

    double getPathWeight(Map<String,Map<String,Double>> graph, String start, String end, Set<String> set) {
        if(!graph.containsKey(start)) {
            return -1.0;
        }
        if(graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }
        set.add(start);

        for(Map.Entry<String,Double> neighbour : graph.get(start).entrySet()) {
            String key = neighbour.getKey();
            Double value = neighbour.getValue();
            if(set.contains(key)) continue;
            double productWeight = getPathWeight(graph,key,end,set);
            if(productWeight!=-1.0) {
                return productWeight * value;
            }
        }
        return -1.0;
    }

    Map<String,Map<String,Double>> buildGraph(List<List<String>> equations,double[] values) {
        Map<String,Map<String,Double>> graph = new HashMap<>();
        for(int i=0;i<equations.size();i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            graph.putIfAbsent(u,new HashMap<>());
            graph.get(u).put(v,values[i]);
            graph.putIfAbsent(v,new HashMap<>());
            graph.get(v).put(u,1/values[i]);
        }
        return graph;
    }
}
