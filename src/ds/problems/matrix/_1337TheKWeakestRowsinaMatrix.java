package ds.problems.matrix;
//https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/
//1337. The K Weakest Rows in a Matrix

import java.util.*;

public class _1337TheKWeakestRowsinaMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });
        for(int i=0;i<mat.length;i++) {
            int count = 0;
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j] == 1) count++;
            }
            priorityQueue.add(new int[]{i,count});
        }
        int[] ans = new int[k];
        int count = 0;
        while (!priorityQueue.isEmpty() && k>0) {
            ans[count++] = priorityQueue.poll()[0];
            k--;
        }
        return ans;
       // return topK(map,k);
    }

    int[] topK(Map<Integer,Integer> map,int k) {
        List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        int[] ans = new int[k];
        for(int i=0;i<k;i++) {
            ans[i] =  list.get(i).getKey();
        }
        return ans;
    }
}
