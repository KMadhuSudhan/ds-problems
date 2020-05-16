package ds.problems.numbers;
//https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
//1281. Subtract the Product and Sum of Digits of an Integer

public class _1281SubtractTheProductAndSumOfDigitsOfAnInteger {
    public static void main(String[] args) {
        _1281SubtractTheProductAndSumOfDigitsOfAnInteger subtractTheProductAndSumOfDigitsOfAnInteger = new _1281SubtractTheProductAndSumOfDigitsOfAnInteger();
        subtractTheProductAndSumOfDigitsOfAnInteger.subtractProductAndSum(234);
    }

    public int subtractProductAndSum(int n) {
        return diff(n);
    }

    int diff(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int r = n % 10;
            sum += r;
            product *= r;
            n /= 10;
        }
        return product - sum;
    }
}
