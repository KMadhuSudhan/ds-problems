package ds.problems.array;
//https://leetcode.com/problems/rank-transform-of-an-array/
//1331. Rank Transform of an Array

import java.util.Comparator;
import java.util.PriorityQueue;

public class _1331RankTransformOfanArray {

    public int[] arrayRankTransform(int[] arr) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0;i<arr.length;i++) {
            priorityQueue.add(new int[]{arr[i],i});
        }
        int prevNumber = -1;
        int count =0;
        while(!priorityQueue.isEmpty()) {
            int[] peek = priorityQueue.poll();
            if(peek[0]!=prevNumber) {
                arr[peek[1]] = ++count;
                prevNumber= peek[0];
            } else {
                arr[peek[1]] = count;
            }
        }
        return arr;
    }
}
