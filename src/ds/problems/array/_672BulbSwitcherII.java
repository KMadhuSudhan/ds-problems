package ds.problems.array;
//https://leetcode.com/problems/bulb-switcher-ii/
//672. Bulb Switcher II

public class _672BulbSwitcherII {

    public int flipLights(int n, int m) {
        n = Math.min(n, 3);
        if (m == 0) return 1;
        if (m == 1) return n == 1 ? 2 : n == 2 ? 3 : 4;
        if (m == 2) return n == 1 ? 2 : n == 2 ? 4 : 7;
        return n == 1 ? 2 : n == 2 ? 4 : 8;
    }
}
