package ds.problems.array;
//https://leetcode.com/problems/bulb-switcher/
//319. Bulb Switcher

public class _319BulbSwitcher {

    public int bulbSwitch(int n) {
        int count =0;
        for(int i=1;i*i<=n;i++) {
            count++;
        }
        return count;
    }
}
