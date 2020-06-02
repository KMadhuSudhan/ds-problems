package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/
//1414. Find the Minimum Number of Fibonacci Numbers Whose Sum Is K


import java.util.ArrayList;
import java.util.List;

public class _1414FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        _1414FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK findtheMinimumNumberofFibonacciNumbersWhoseSumIsK = new _1414FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK();
        findtheMinimumNumberofFibonacciNumbersWhoseSumIsK.findMinFibonacciNumbers(7);
    }

    /* method 1
    public int findMinFibonacciNumbers(int k) {
        int count = 0;
        while (k != 0) {
            k -= greatestFib(k, 1, 1);
            count++;
        }

        return count;
    }

    int greatestFib(int k, int a, int b) {
        while (a + b <= k) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    } */

    /* method 2 */
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibNumbers = fibNumbers(k, 1, 1);
        int count = 1;
        int j = fibNumbers.size() - 1;
        k -= fibNumbers.get(fibNumbers.size() - 1);
        while (k > 0) {
            int index = findGreatestFib(fibNumbers, k, j);
            count++;
            k -= fibNumbers.get(index);
            j = index - 1;
        }
        return count;
    }

    int findGreatestFib(List<Integer> fibNumbers, int target, int high) {
        int low = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (fibNumbers.get(mid) <= target && (mid == fibNumbers.size() - 1 || fibNumbers.get(mid + 1) > target)) {
                return mid;
            } else if (fibNumbers.get(mid) < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 0;
    }

    List<Integer> fibNumbers(int k, int a, int b) {
        List<Integer> list = new ArrayList<>();
        if (k == 1) {
            list.add(1);
            return list;
        }
        while (a + b <= k) {
            int c = a + b;
            a = b;
            b = c;
            list.add(c);
        }
        return list;
    }
}
