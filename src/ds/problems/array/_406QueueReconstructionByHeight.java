package ds.problems.array;
//https://leetcode.com/problems/queue-reconstruction-by-height/
//406. Queue Reconstruction by Height

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _406QueueReconstructionByHeight {
    public static void main(String[] args) {
        int[][] arr = {
                {7,0},
                {4,4},
                {7,1},
                {5,0},
                {6,1},
                {5,2}
        };
        _406QueueReconstructionByHeight queueReconstructionByHeight = new _406QueueReconstructionByHeight();
        queueReconstructionByHeight.reconstructQueue(arr);
    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new ArrayList<>();
        for(int[] p : people){
            res.add(p[1], p);
        }
        int n = people.length;
        return res.toArray(new int[n][2]);
    }
}
