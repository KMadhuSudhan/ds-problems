package ds.problems.array;
//https://leetcode.com/problems/maximize-distance-to-closest-person/
//849. Maximize Distance to Closest Person

public class _849MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0,prevOne = -1;
        for(int i=0;i<seats.length;i++) {
            if(seats[i] == 1) {
                int distance = prevOne == -1 ? i : (i-prevOne)/2;
                maxDistance = Math.max(distance,maxDistance);
                prevOne = i;
            }
        }
        maxDistance = Math.max(maxDistance, seats.length - 1 - prevOne);
        return maxDistance;
    }
}
