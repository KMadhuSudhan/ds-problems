package ds.problems.trees;
//https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
//1443. Minimum Time to Collect All Apples in a Tree

import java.util.*;

public class _1443MinimumTimeToCollectApples {

    int res = 0;
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] ele: edges){
            if(map.containsKey(ele[0])==false){
                map.put(ele[0], new HashSet<>());
            }
            if(map.containsKey(ele[1])==false){
                map.put(ele[1], new HashSet<>());
            }

            map.get(ele[0]).add(ele[1]);
            map.get(ele[1]).add(ele[0]);
        }

        hasAppleCheck(map, hasApple, 0, -1);
        return 2*res;
    }


    public boolean hasAppleCheck(Map<Integer, Set<Integer>> map,
                                 List<Boolean> hasApple, int node, int parent_node){
        boolean check = false;
        if(hasApple.get(node)){
            check = true;
        }

        for(int next_node: map.get(node)){
            if(next_node == parent_node){
                continue;
            }

            if(hasAppleCheck(map, hasApple, next_node, node)){
                res++;
                check = true;
            }

        }

        return check;

    }
}
