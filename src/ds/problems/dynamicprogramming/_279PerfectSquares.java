package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/perfect-squares/
//279. Perfect Squares

import java.util.ArrayList;
import java.util.List;

public class _279PerfectSquares {
    public static void main(String[] args) {
        _279PerfectSquares perfectSquares = new _279PerfectSquares();
        System.out.println(perfectSquares.numSquares(12));
    }

    public int numSquares(int n) {
        List<Integer> sqaures = new ArrayList<>();
        for (int i = 1; i * i <= n; i++) {
            sqaures.add(i * i);
        }
        int[][] dp = new int[sqaures.size() + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= sqaures.size(); i++) {
            int square = sqaures.get(i - 1);
            for (int j = 1; j <= n; j++) {
                if (square > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - square]);
                }
            }
        }
        return dp[sqaures.size()][n];
    }
}
