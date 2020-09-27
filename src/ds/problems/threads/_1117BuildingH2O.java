package ds.problems.threads;
//https://leetcode.com/problems/building-h2o/
//1117. Building H2O

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class _1117BuildingH2O {
    private static final Semaphore hs = new Semaphore(2, true);
    private static final Semaphore os = new Semaphore(1, true);

    private static final CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
        public void run() {
        }
    });
    public _1117BuildingH2O() {

    }

    public static void main(String[] args) {
        _1117BuildingH2O buildingH2O = new _1117BuildingH2O();

    }
    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        try {
            // acquire if space available for H
            hs.acquire();
            //wait at barrier to reach till 3
            barrier.await();
            // releaseHydrogen.run() outputs "H". Do not change or remove this line.

            releaseHydrogen.run();
            // release semaphone
            hs.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        try {
            // acquire if space available for O
            os.acquire();
            //wait at barrier to reach till 3
            barrier.await();

            // releaseOxygen.run() outputs "O". Do not change or remove this line.
            releaseOxygen.run();
            // release semaphone
            os.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
