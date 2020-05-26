package ds.problems.matrix;
//https://leetcode.com/problems/cinema-seat-allocation/
//1386. Cinema Seat Allocation

import java.util.HashMap;
import java.util.Map;

public class _1386CinemaSeatAllocation {
    public static void main(String[] args) {
        int[][] reservedSeats = new int[][]{
                {1,2},
                {1,3},
                {1,8},
                {2,6},
                {3,1},
                {3,10}
        };
        _1386CinemaSeatAllocation cinemaSeatAllocation = new _1386CinemaSeatAllocation();
        System.out.println(cinemaSeatAllocation.maxNumberOfFamilies(3,reservedSeats));
    }
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,int[]> map = new HashMap<>();

        for(int i=0;i<reservedSeats.length;i++) {
            int[] row = map.getOrDefault(reservedSeats[i][0],new int[11]);
            row[reservedSeats[i][1]-1] = 1;
            map.put(reservedSeats[i][0],row);
        }

        int count =  (n - map.size())*2;
        for(Map.Entry<Integer,int[]> entry: map.entrySet()) {
            int[] row = entry.getValue();
            int leftSum = 0;
            int middleSum = 0;
            int rightSum = 0;

            //left sum
            for(int i=1;i<=4;i++) {
                leftSum+=row[i];
            }

            //middle sum
            for(int i=3;i<=6;i++) {
                middleSum+=row[i];
            }

            //right sum
            for(int i=5;i<=8;i++) {
                rightSum+=row[i];
            }

            if(leftSum == 0) {
                count++;
            }
            if(rightSum == 0) {
                count++;
            }
            if(middleSum == 0 && rightSum>0 && leftSum>0) {
                count++;
            }
        }
        return count;
    }
}
