package ds.problems.threads;
//https://leetcode.com/problems/print-zero-even-odd
//1116. Print Zero Even Odd


import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class _1116PrintZeroEvenOdd {
    private int n;
    private int count;
    private Semaphore s0, s1, s2;

    public _1116PrintZeroEvenOdd(int n) {
        this.n = n;
        count = 0;
        s0 = new Semaphore(1);
        s1 = new Semaphore(0);
        s2 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s0.acquire();
            printNumber.accept(0);
            count++;
            if (count % 2 == 1) {
                s1.release();
            } else {
                s2.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n/2; i++) {
            s2.acquire();
            printNumber.accept(count);
            s0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < Math.ceil((double)n/2); i++) {
            s1.acquire();
            printNumber.accept(count);
            s0.release();
        }
    }
}
