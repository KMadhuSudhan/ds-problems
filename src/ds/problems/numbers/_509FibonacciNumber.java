package ds.problems.numbers;
//https://leetcode.com/problems/fibonacci-number/
//509. Fibonacci Number

public class _509FibonacciNumber {

    public static void main(String[] args) {
        _509FibonacciNumber fibonacciNumber = new _509FibonacciNumber();
        fibonacciNumber.fib(2);
    }
    public int fib(int N) {
        if(N == 0) return 0;
        if(N == 1) return 1;
        int a = 0;
        int b =1;
        for(int i=1;i<N;i++) {
            int c = a+b;
            a=b;
            b=c;
        }
        return b;
    }
}
