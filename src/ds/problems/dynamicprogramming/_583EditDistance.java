package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/edit-distance/
//72. Edit Distance

public class _583EditDistance {
    public static void main(String[] args) {
        _583EditDistance editDistance = new _583EditDistance();
        editDistance.minDistance("horse","ros");
    }
    public int minDistance(String word1, String word2) {
        char[] word1Chars = word1.toCharArray();
        char[] word2Chars = word2.toCharArray();

        int[][] dp = new int[word1Chars.length + 1][word2Chars.length+1];

        for (int i=1;i<=word1Chars.length;i++) {
            dp[i][0] = i;
        }

        for (int i=1;i<=word2Chars.length;i++) {
            dp[0][i] = i;
        }

        for (int i=1;i<=word1Chars.length;i++) {
            for (int j=1;j<=word2Chars.length;j++) {
                if(word1Chars[i-1] == word2Chars[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    int minDistance = Math.min(dp[i-1][j-1],dp[i-1][j]);
                    dp[i][j] = 1 + Math.min(minDistance,dp[i][j-1]);
                }
            }
        }
        return dp[word1Chars.length][word2Chars.length];
    }
}
