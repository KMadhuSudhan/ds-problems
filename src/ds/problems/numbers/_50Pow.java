package ds.problems.numbers;
//https://leetcode.com/problems/powx-n/
//50. Pow(x, n)

public class _50Pow {

    public double myPow(double x, int n) {
        if (n >= 0) {
            return pow(x, n);
        } else {
            return pow(1 / x, n);
        }
    }

    public double pow(double x, int n) {
        if (n == 0) return 1;
        return pow(x * x, n / 2) * (n % 2 == 0 ? 1 : x);
    }
}
