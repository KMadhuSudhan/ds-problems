package ds.problems.geometry;
//https://leetcode.com/problems/check-if-it-is-a-straight-line/
//1232. Check If It Is a Straight Line

public class _1232CheckIfItIsaStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        for(int i=2;i<coordinates.length;i++) {
            int total = x1*(y2-coordinates[i][1]) + x2*(coordinates[i][1] - y1) + coordinates[i][0]*(y1 - y2);
            if(total!=0) {
                return false;
            }
        }
        return true;
    }
}
