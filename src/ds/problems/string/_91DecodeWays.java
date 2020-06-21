package ds.problems.string;
//https://leetcode.com/problems/decode-ways/
//91. Decode Ways

/**
 * 1 -> A -> 1way
 * 12 -> AB, L -> 2ways
 * 122 = 1 + 22 or 12 + 2 = 1way + 2ways = 3ways -> AV, ABB, LB
 * 1221 = 12 + 21 or 122 + 1 = 2ways + 3ways = 5ways -> ABU, LU, AVA, ABBA, LBA
 */
public class _91DecodeWays {

    public int numDecodings(String s) {
        if (s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int length = s.length();
        // dp[i] = How many ways for substring(0, i + 1)
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            int curDigit = Character.getNumericValue(s.charAt(i));
            if (curDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            int lastDigit = Character.getNumericValue(s.charAt(i - 1));
            if (lastDigit >= 1 && lastDigit * 10 + curDigit <= 26) {
                dp[i] += i == 1 ? 1 : dp[i - 2];
            }
        }
        return dp[length - 1];
    }
}
