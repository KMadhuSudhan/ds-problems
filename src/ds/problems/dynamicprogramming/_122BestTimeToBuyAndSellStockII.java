package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//122. Best Time to Buy and Sell Stock II

public class _122BestTimeToBuyAndSellStockII {
    public static void main(String[] args) {
        _122BestTimeToBuyAndSellStockII bestTimeToBuyAndSellStockII = new _122BestTimeToBuyAndSellStockII();
        int[] prices = {7,1,5,3,6,4};
        bestTimeToBuyAndSellStockII.maxProfit(prices);
    }

    public int maxProfit(int[] prices) {
        if(prices.length<2) return 0;
        int maxProfit = 0,i=0;
        int valley = prices[0];
        int peak = prices[0];
        while (i<prices.length-1) {
            while (i<prices.length-1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            while (i<prices.length-1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peak = prices[i];
            maxProfit+=peak-valley;
        }
        return maxProfit;
    }
}
