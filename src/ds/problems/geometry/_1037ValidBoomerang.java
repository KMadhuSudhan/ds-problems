package ds.problems.geometry;
//https://leetcode.com/problems/valid-boomerang/
//1037. Valid Boomerang
public class _1037ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        int x1 = points[0][0];
        int y1 = points[0][1];
        int x2 = points[1][0];
        int y2 = points[1][1];
        int x3 = points[2][0];
        int y3 = points[2][1];
        int total = x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2);
        if(total == 0) {
            return false;
        }
        return true;
    }
}
