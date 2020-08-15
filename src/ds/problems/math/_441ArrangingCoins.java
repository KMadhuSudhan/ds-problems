package ds.problems.math;
//https://leetcode.com/problems/arranging-coins/
//441. Arranging Coins
//https://leetcode.com/problems/arranging-coins/discuss/768916/1-Liner-Math-detailed-Explanation

public class _441ArrangingCoins {
    public int arrangeCoins(int n) {
        //k*(k+1)/2<=n
        //k2+k<=2n
        //k2+k + 1/4 - 1/4<=2n+1/4
        //(k+1/2)2<=(8n+1)/4
        //k+1/2<=Sqr(8n+1)/2
        //k<=Sqr(8n+1)/2-1/2
        //k<=1/2(sqrt(8n+1)-1)
        return (int)(Math.sqrt((8L * n + 1)) - 1)/2;
    }
}
