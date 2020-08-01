package ds.problems.array;
//https://leetcode.com/problems/last-moment-before-all-ants-fall-out-of-a-plank/
//1503. Last Moment Before All Ants Fall Out of a Plank

public class _1503LastMomentBeforeAllAntsFallOutofaPlank {

    public int getLastMoment(int n, int[] left, int[] right) {
        int leftMax = 0;
        for (int i = 0; i < left.length; ++i) {
            leftMax = Math.max(left[i], leftMax);
        }
        int rightMin = n;
        for (int i = 0; i < right.length; ++i) {
            rightMin = Math.min(right[i], rightMin);
        }
        return Math.max(leftMax, n - rightMin);
    }
}
