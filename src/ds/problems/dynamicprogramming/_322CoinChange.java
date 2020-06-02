package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/coin-change/
//322. Coin Change

import java.util.Arrays;

public class _322CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0] = 0;
        for(int i=0;i<coins.length;i++) {
            for(int j=coins[i];j<=amount;j++) {
                dp[j] = Math.min(dp[j],1 + dp[j-coins[i]]);
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }

}
