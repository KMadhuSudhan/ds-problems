package ds.problems.matrix;
//https://leetcode.com/problems/matrix-cells-in-distance-order/
//1030. Matrix Cells in Distance Order

import java.util.ArrayList;
import java.util.List;

public class _1030MatrixCellsinDistanceOrder {

    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<List<int[]>> ans = new ArrayList<>();
        for(int i=0; i<R+C; i++) {
            ans.add(new ArrayList<int[]>());
        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                int dist = Math.abs(r0-i) + Math.abs(c0-j);
                ans.get(dist).add(new int[]{i,j});
            }
        }
        int[][] res = new int[R*C][2];
        int idx = 0;
        for(List<int[]> coords : ans) {
            for(int[] coord : coords) {
                res[idx++] = coord;
            }
        }
        return res;
    }

}
