package ds.problems.matrix;
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//378. Kth Smallest Element in a Sorted Matrix

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  5,  9},
                {10, 11, 13},
                {12, 13, 15}
        };
        KthSmallestElementInASortedMatrix kthSmallestElementInASortedMatrix = new KthSmallestElementInASortedMatrix();
        kthSmallestElementInASortedMatrix.kthSmallest(matrix,8);
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i=0;i<matrix.length;i++) {
            for (int j=0;j<matrix[0].length;j++) {
                pq.add(matrix[i][j]);
                if(pq.size() > k) {
                    pq.poll();
                }
            }
        }
        return pq.poll();
    }
/*
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        // lo < hi , not lo <= hit
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
                //
            else hi = mid-1;
        }
        return lo;
    }

    public int lessEqual(int[][] matrix, int target) {
        int cnt = 0, N = matrix.length, i = N - 1, j = 0;
        while (i >= 0 && j < N) {
            if (matrix[i][j] > target) i--;
            else {
                cnt = cnt + i + 1;
                j++;
            }
        }
        return cnt;
    }
    */

    /*
    * public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, lo = matrix[0][0], hi = matrix[n - 1][n - 1];
        // lo < hi , not lo <= hit
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) lo = mid + 1;
                //
            else hi = mid;
        }
        return lo;
    }

    public int lessEqual(int[][] matrix, int target) {
        int cnt = 0, N = matrix.length, i = N - 1, j = 0;
        while (i >= 0 && j < N) {
            if (matrix[i][j] > target) i--;
            else {
                cnt = cnt + i + 1;
                j++;
            }
        }
        return cnt;
    }
    */
}
