package ds.problems.array;
//https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
//1465. Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts

import java.util.Arrays;

public class _1465MaximumAreaofaPieceofCake {

    public int maxArea(int h, int w, int[] ho, int[] ve) {
        Arrays.sort(ho);
        Arrays.sort(ve);
        long maxR = ho[0], maxC = ve[0];
        // Finding the maximum gap between horizontal cuts
        for (int i = 1; i<ho.length; i++) {
            maxR = Math.max(maxR, ho[i] - ho[i-1]);
        }
        maxR = Math.max(maxR, h - ho[ho.length - 1]);
        // Finding the maximum gap between vertical cuts
        for (int i = 1; i<ve.length; i++) {
            maxC = Math.max(maxC, ve[i] - ve[i-1]);
        }
        maxC = Math.max(maxC, w - ve[ve.length - 1]);

        return (int)((maxR * maxC) % (1000000000 + 7));
    }

}
