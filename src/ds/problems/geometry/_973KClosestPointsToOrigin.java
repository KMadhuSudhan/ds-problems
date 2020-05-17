package ds.problems.geometry;
//https://leetcode.com/problems/k-closest-points-to-origin/
//973. K Closest Points to Origin

import java.util.Comparator;
import java.util.PriorityQueue;

public class _973KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<ClosestPoints> pq = new PriorityQueue<ClosestPoints>(new Comparator<ClosestPoints>() {
            @Override
            public int compare(ClosestPoints p1,ClosestPoints p2) {
                return p1.distance - p2.distance;
            }
        });
        for(int i=0;i<points.length;i++) {
            int d = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            ClosestPoints point = new ClosestPoints(d,i);
            pq.offer(point);
        }

        int[][] ans = new int[K][2];
        int count =0;
        while(!pq.isEmpty() && count<K) {
            int[] point = new int[2];
            ClosestPoints closestPoint = pq.poll();
            point[0] = points[closestPoint.index][0];
            point[1] = points[closestPoint.index][1];
            ans[count] = point;
            count++;
        }
        return ans;
    }

    class ClosestPoints {
        int distance;
        int index;
        ClosestPoints(int distance,int index) {
            this.distance = distance;
            this.index = index;
        }
    }
}
