package ds.problems.array;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallest {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 5, 7, 9},
                {3, 4},
                {2, 7, 8}
        };
        KthSmallest kthSmallest = new KthSmallest();
        kthSmallest.kthSmallest(arr,5);
    }
    public int kthSmallest(int[][] arr, int k) {
        // write your code here
        PriorityQueue<Integer> pq = new PriorityQueue(Comparator.reverseOrder());
        for(int i=0;i<arr.length;i++) {
            int length = arr[i].length;
            for(int j=0;j<length;j++) {
                pq.add(arr[i][j]);

                if(pq.size()>k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
}
