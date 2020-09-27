package ds.problems.threads;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class FizzBuzzMultithreaded {
    private int n;
    private AtomicInteger counter;
    public FizzBuzzMultithreaded(int n) {
        this.n = n;
        this.counter = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while(counter.get()<=n) {
            synchronized (counter) {
                if (counter.get() <= n && counter.get() % 3 == 0 && counter.get() % 5 != 0) {
                    printFizz.run();
                    counter.incrementAndGet();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while(counter.get()<=n) {
            synchronized(counter) {
                if (counter.get() <= n && counter.get() % 3 != 0 && counter.get() % 5 == 0) {
                    printBuzz.run();
                    counter.incrementAndGet();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(counter.get()<=n) {
            synchronized (counter) {
                if (counter.get() <= n && counter.get() % 3 == 0 && counter.get() % 5 == 0) {
                    printFizzBuzz.run();
                    counter.incrementAndGet();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while(counter.get()<=n) {
            synchronized (counter) {
                if (counter.get() <= n && counter.get() % 3 != 0 && counter.get() % 5 != 0) {
                    printNumber.accept(counter.get());
                    counter.incrementAndGet();
                }
            }
        }
    }
}
