package ds.problems.array;
//https://leetcode.com/problems/reveal-cards-in-increasing-order/
//950. Reveal Cards In Increasing Order

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _950RevealCardsInIncreasingOrder {

    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> queue = new LinkedList();
        queue.offer(deck[deck.length-1]);
        for(int i=deck.length-2;i>=0;i--) {
            queue.offer(queue.poll());
            queue.offer(deck[i]);
        }
        int[] res = new int[deck.length];
        for(int i=deck.length-1;i>=0;i--) {
            res[i] = queue.poll();
        }
        return res;
    }
}
