package ds.problems.bits;
//https://leetcode.com/problems/sum-of-two-integers/
//371. Sum of Two Integers

public class _371SumOfTwoIntegers {
    public static void main(String[] args) {
        _371SumOfTwoIntegers sumOfTwoIntegers = new _371SumOfTwoIntegers();
        sumOfTwoIntegers.getSum(1,2);
    }

    public int getSum(int a, int b) {
        while(b!=0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}
