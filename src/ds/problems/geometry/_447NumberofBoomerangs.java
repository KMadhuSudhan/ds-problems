package ds.problems.geometry;
//https://leetcode.com/problems/number-of-boomerangs/
//447. Number of Boomerangs

import java.util.HashMap;
import java.util.Map;

public class _447NumberofBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();   //for each starting point i;
            for (int j = 0; j < points.length; j++) {
                int a = points[i][0] - points[j][0];
                int b = points[i][1] - points[j][1];
                int dist = a * a + b * b;
                int cnt = map.getOrDefault(dist, 0);
                res += cnt * 2;  // j and k are switchable
                map.put(dist, cnt + 1);
            }
        }
        return res;
    }
}
