package ds.problems.numbers;
//https://leetcode.com/problems/n-th-tribonacci-number/
//1137. N-th Tribonacci Number

public class _1137NthTribonacciNumber {
    public static void main(String[] args) {
        _1137NthTribonacciNumber nthTribonacciNumber = new  _1137NthTribonacciNumber();
        System.out.println(nthTribonacciNumber.tribonacci(4));
    }
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int a = 0;
        int b = 1;
        int c = 1;
        for(int i=3;i<=n;i++) {
            int d = a + b +c;
            a =b;
            b = c;
            c = d;
        }
        return c;
    }
}
