package ds.problems.geometry;
//https://leetcode.com/problems/rectangle-overlap/
//836. Rectangle Overlap

public class _836RectangleOverlap {

    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int[] rdiag1 = new int[]{rec1[0], rec1[3], rec1[2], rec1[1]};
        int[] rdiag2 = new int[]{rec2[0], rec2[3], rec2[2], rec2[1]};

        return isOverlap(rec1, rec2) || isOverlap(rec2, rec1)  || isOverlap(rdiag1, rdiag2) || isOverlap(rdiag2, rdiag1);
    }

    private boolean isOverlap(int[] c1, int[] c2) {
        // Similar max and min logic can be used for finding overlapping intervals
        int xstart = Math.max(c1[0], c2[0]);
        int xend = Math.min(c1[2],c2[2] );

        int ystart = Math.max(c1[1], c2[1]);
        int yend = Math.min(c1[3], c2[3]);

        return xstart<xend && ystart<yend;
    }
}
