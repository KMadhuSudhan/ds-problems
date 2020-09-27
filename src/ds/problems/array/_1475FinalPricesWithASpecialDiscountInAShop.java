package ds.problems.array;
//https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
//1475. Final Prices With a Special Discount in a Shop

public class _1475FinalPricesWithASpecialDiscountInAShop {
    public int[] finalPrices(int[] prices) {
        int n = prices.length,top=-1;
        int[] stack = new int[n];
        for(int i=0;i<n;i++) {
            while(top != -1 && prices[stack[top]] >= prices[i]) {
                int index = stack[top--];
                prices[index] = prices[index] - prices[i];
            }
            stack[++top] = i;
        }
        return prices;
    }
}
