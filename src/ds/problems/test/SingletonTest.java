package ds.problems.test;

import java.util.PriorityQueue;

public class SingletonTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(2);
        priorityQueue.add(3);
        priorityQueue.add(7);
        priorityQueue.add(1);
        System.out.println(priorityQueue.poll());
    }
}
