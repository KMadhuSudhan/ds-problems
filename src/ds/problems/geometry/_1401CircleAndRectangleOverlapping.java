package ds.problems.geometry;
//https://leetcode.com/problems/circle-and-rectangle-overlapping/
//1401. Circle and Rectangle Overlapping

public class _1401CircleAndRectangleOverlapping {
    public boolean checkOverlap(int r, int xc, int yc, int x1, int y1, int x2, int y2) {
        if (xc + r < x1 || xc - r > x2 || yc + r < y1 || yc - r > y2) return false;
        if (xc < x1 && yc < y1 && longer(xc, yc, x1, y1, r)) return false;
        if (xc < x1 && yc > y2 && longer(xc, yc, x1, y2, r)) return false;
        if (xc > x2 && yc < y1 && longer(xc, yc, x2, y1, r)) return false;
        if (xc > x2 && yc > y2 && longer(xc, yc, x2, y2, r)) return false;
        return true;
    }

    private boolean longer(int xc, int yc, int x, int y, int r) {
        return (xc - x) * (xc - x) + (yc - y) * (yc - y) > r * r;
    }
}
