package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//121. Best Time to Buy and Sell Stock

public class _121BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        _121BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new _121BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(bestTimeToBuyAndSellStock.maxProfit(prices));
    }
    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<prices.length;i++) {
            if(prices[i] <  minPrice) {
                minPrice = prices[i];
            }
            if((prices[i] - minPrice) > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}
