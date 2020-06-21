package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/coin-change-2/
//518. Coin Change 2

public class _518CoinChangeII {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<=amount;j++) {
                dp[j]+=dp[j-coins[i]];
            }
        }
        return dp[amount];
    }
}
