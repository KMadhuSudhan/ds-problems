package ds.problems.array;
//https://leetcode.com/problems/play-with-chips/
//1217. Play with Chips

public class _1217PlaywithChips {
    public int minCostToMoveChips(int[] chips) {
        int odd = 0, even = 0;
        for (int c : chips) {
            if (c % 2 == 1 ) odd++;
            else even++;
        }
        return Math.min(odd, even);
    }
}
