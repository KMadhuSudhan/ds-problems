package ds.problems.geometry;
//https://leetcode.com/problems/rectangle-area/
//223. Rectangle Area

public class _223RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int l1[] = {A, B};
        int r1[] = {C, D};
        int l2[] = {E, F};
        int r2[] = {G, H};
        int area1 = (r1[0] - l1[0]) * (r1[1]- l1[1]);
        int area2 = (l2[0] - r2[0]) * (l2[1]- r2[1]);
        //is interaction there
        int interArea = 0;
        if(isOverlap( l1, r1, l2, r2)){

            interArea = intersactionArea(l1,r1, l2, r2);

        }
        return area1+ area2 - interArea;

    }

    boolean isOverlap(int[] l1,int[] r1,int[] l2, int[] r2) {
        //Use exclusion

        if (l1[0] >= r2[0] || r1[0] <= l2[0]) {
            return false;
        }
        if (l1[1] >= r2[1] || r1[1] <= l2[1]) {
            return false;
        }
        return true;
    }

    int intersactionArea(int[] l1,int[] r1,int[] l2, int[] r2){
        int intercationX = Math.abs(Math.max(l1[0], l2[0]) - Math.min(r1[0], r2[0]));
        int intercationY = Math.abs(Math.max(l1[1], l2[1]) - Math.min(r1[1], r2[1]));
        return intercationX * intercationY;

    }
}
