package ds.problems.string;
//https://leetcode.com/problems/bulb-switcher-iv/
//1529. Bulb Switcher IV

public class _1529BulbSwitcherIV {
    public int minFlips(String target) {
        char curr = '0';
        int ans = 0;
        for (char c : target.toCharArray()) {
            if (c != curr) {
                curr = c;
                ans++;
            }
        }
        return ans;
    }
}
