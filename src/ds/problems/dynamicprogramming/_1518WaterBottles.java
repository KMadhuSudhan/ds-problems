package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/water-bottles/
//1518. Water Bottles

public class _1518WaterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int emptyBottel = 0;
        int res = 0;
        while(numBottles > 0){
            res = res + numBottles;
            emptyBottel = emptyBottel + numBottles;
            numBottles =  emptyBottel/numExchange;
            emptyBottel = emptyBottel%numExchange;
        }
        return res;
    }
}
