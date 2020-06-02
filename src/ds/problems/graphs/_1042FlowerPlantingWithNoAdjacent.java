package ds.problems.graphs;
//https://leetcode.com/problems/flower-planting-with-no-adjacent/
//1042. Flower Planting With No Adjacent

import java.util.ArrayList;
import java.util.List;

public class _1042FlowerPlantingWithNoAdjacent {

    public int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> graph = new ArrayList();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < paths.length; i++) {
            int firstNode = paths[i][0];
            int secondNode = paths[i][1];
            graph.get(firstNode).add(secondNode);
            graph.get(secondNode).add(firstNode);
        }

        int[] ans = new int[N];
        for (int i = 1; i <=N; i++) {

            boolean one = true;
            boolean two = true;
            boolean three = true;

            for (int adj : graph.get(i)) {
                switch (ans[adj - 1]) {
                    case 1:
                        one = false;
                        break;
                    case 2:
                        two = false;
                        break;
                    case 3:
                        three = false;
                        break;
                }
            }
            if(one) {
                ans[i-1] = 1;
            } else if(two) {
                ans[i-1] = 2;
            } else if(three) {
                ans[i-1] = 3;
            } else {
                ans[i-1] = 4;
            }
        }
        return ans;
    }
}
