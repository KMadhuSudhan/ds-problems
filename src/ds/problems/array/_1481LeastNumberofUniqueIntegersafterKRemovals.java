package ds.problems.array;
//https://leetcode.com/problems/least-number-of-unique-integers-after-k-removals/submissions/
//1481. Least Number of Unique Integers after K Removals

import java.util.*;

public class _1481LeastNumberofUniqueIntegersafterKRemovals {

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int a: arr) {
            frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        queue.addAll(frequencyMap.keySet());

        while (!queue.isEmpty() && k > 0) {
            int key = queue.poll();
            if (frequencyMap.get(key) > 1) {
                frequencyMap.put(key, frequencyMap.get(key) - 1);
                queue.add(key);
            }
            k--;
        }

        return queue.size();
    }
}
