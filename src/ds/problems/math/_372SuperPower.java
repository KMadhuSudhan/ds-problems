package ds.problems.math;

public class _372SuperPower {
    public int superPow(int a, int[] b) {
        int ans = 1;

        for (int i : b) {
            ans = (pow(ans, 10) * pow(a, i)) % 1337;
        }

        return ans;
    }


    private int pow(int x, int y) {
        int a = 1;

        while (y-->0) {
            a = ((a) * (x % 1337)) % 1337;
        }
        return a;
    }
}
