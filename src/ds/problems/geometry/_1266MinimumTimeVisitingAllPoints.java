package ds.problems.geometry;
//https://leetcode.com/problems/minimum-time-visiting-all-points
//1266. Minimum Time Visiting All Points


public class _1266MinimumTimeVisitingAllPoints {

    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for(int i = 0; i < points.length - 1; i++)
            time += Math.max( Math.abs(points[i][0] - points[i+1][0]), Math.abs(points[i][1] - points[i+1][1]));
        return time;
    }

}
