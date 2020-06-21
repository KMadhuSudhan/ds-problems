package ds.problems.array;
//https://leetcode.com/problems/distance-between-bus-stops/
//1184. Distance Between Bus Stops

public class _1184DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        _1184DistanceBetweenBusStops distanceBetweenBusStops = new _1184DistanceBetweenBusStops();
        System.out.println(distanceBetweenBusStops.distanceBetweenBusStops(nums,0,3));
    }
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int s = start;
        int d = destination;
        int s_d = 0;   // Source to destination clock wise direction
        int n = distance.length;
        while(s != d)
        {
            s_d += distance[s];
            s = (s + 1) % n;
        }

        s = destination;
        d = start;
        int d_s = 0; // Desination to source  - Anti clockwise direction
        while(s != d)
        {
            d_s += distance[s];
            s = (s + 1) % n;
        }
        return Math.min(s_d, d_s);
    }
}
