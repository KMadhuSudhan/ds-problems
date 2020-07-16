package ds.problems.system.design;
//https://leetcode.com/problems/the-dining-philosophers/
//1226. The Dining Philosophers

public class _1226TheDiningPhilosophers {

    private Integer[] forks	= new Integer[] {0, 0, 0, 0, 0};

    public _1226TheDiningPhilosophers() {

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int leftIndex = philosopher;
        int rightIndex = philosopher == 0 ? 4 : philosopher -1;
        synchronized(forks[leftIndex]) {
            pickLeftFork.run( );
            synchronized(forks[rightIndex]) {
                pickRightFork.run();
            }
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        }
    }

}
