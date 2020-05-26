package ds.problems.array;
//https://leetcode.com/problems/interval-list-intersections/
//986. Interval List Intersections

import java.util.ArrayList;
import java.util.List;

public class _986IntervalListIntersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> result = new ArrayList<int[]>();
        int a = 0; int b = 0;
        while(a<A.length && b<B.length) {
            int maxMin = Math.max(A[a][0], B[b][0]);
            int minMax = Math.min(A[a][1], B[b][1]);
            // check if it's an intersection
            if(maxMin <= minMax) {
                result.add(new int[]{maxMin, minMax});
            }

            if(A[a][1] < B[b][1]) { //go right in A list
                a++;
            } else if(A[a][1] > B[b][1]) { //go right in B list
                b++;
            } else { //go right in both A and B lists
                a++;
                b++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
