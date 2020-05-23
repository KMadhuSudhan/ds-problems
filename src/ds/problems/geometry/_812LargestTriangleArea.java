package ds.problems.geometry;
//https://leetcode.com/problems/largest-triangle-area/
//812. Largest Triangle Area
//A = (1/2) [x1 (y2- y3 )+x2 (y3-y1 )+x3(y1-y2)]
//https://byjus.com/maths/area-triangle-coordinate-geometry/
public class _812LargestTriangleArea {

    public double largestTriangleArea(int[][] points) {
        double result = 0.0;
        for (int i=0;i<points.length;i++) {
            for (int j=i+1;j< points.length;j++) {
                for (int k=j+1;k< points.length;k++) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];

                    int x2 = points[j][0];
                    int y2 = points[j][1];

                    int x3 = points[k][0];
                    int y3 = points[k][1];
                    double area = Math.abs(x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)) * 0.5;
                    result = Math.max(area, result);
                }
            }
        }
        return result;
    }
}
