package ds.problems.array;
//https://leetcode.com/problems/minimum-area-rectangle-ii/
//963. Minimum Area Rectangle II

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class _963MinimumAreaRectangleII {
    public static void main(String[] args) {
        _963MinimumAreaRectangleII minimumAreaRectangleII = new _963MinimumAreaRectangleII();
    }

    public double minAreaFreeRect(int[][] points) {
        int result = Integer.MAX_VALUE;
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            Point point = new Point(points[i][0], points[i][1]);
            pointSet.add(point);
        }
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if (x1 != x2 && y1 != y2) {
                    Point p1 = new Point(x1, y1);
                    Point p2 = new Point(x2, y2);
                    Point p3 = new Point(x1, y2);
                    Point p4 = new Point(x2, y1);
                    if (pointSet.contains(p3) && pointSet.contains(p4)) {
                        int area = Math.abs(p1.x - p2.x) * Math.abs(p1.y - p2.y);
                        result = Math.min(area, result);
                    }
                }
            }
        }
        if (result == Integer.MAX_VALUE) return 0;
        return result;
    }

    class Point {
        int x;
        int y;

        Point(int i, int j) {
            x = i;
            y = j;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Point) obj).x == this.x && ((Point) obj).y == this.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
