package ds.problems.math;
//https://leetcode.com/problems/broken-calculator/
//991. Broken Calculator

public class _991BrokenCalculator {
    public int brokenCalc(int X, int Y) {
        if (X == Y) return 0;
        if (X > Y) return X - Y;

        if (Y == X * 2) return 1;
        else if (Y % 2 == 0) return brokenCalc(X, Y / 2) + 1;
        else return brokenCalc(X, Y + 1) + 1;
    }
}
