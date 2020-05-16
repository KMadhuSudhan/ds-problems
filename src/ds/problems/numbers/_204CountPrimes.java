package ds.problems.numbers;
//https://leetcode.com/problems/count-primes/
//204. Count Primes

public class _204CountPrimes {
    public static void main(String[] args) {
        _204CountPrimes countPrimes = new _204CountPrimes();
        System.out.println(countPrimes.countPrimes(10));
    }
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        int count = n-2;
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
                count--;
            }
        }
//        int count = 0;
//        for (int i = 2; i < n; i++) {
//            if (isPrime[i]) count++;
//        }
        return count;
    }
}
