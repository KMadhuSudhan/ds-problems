package ds.problems.bits;
//https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/
//1356. Sort Integers by The Number of 1 Bits

import java.util.*;

public class _1356SortIntegersbyTheNumberof1Bits {

    public int[] sortByBits(int[] arr) {
        int[] result = new int[arr.length];

        TreeMap<Integer,List<Integer>> tm = new TreeMap<>();

        for(int i: arr) {
            int sb = countSetBits(i);
            List<Integer> l = tm.getOrDefault(sb, new ArrayList<>());
            l.add(i);
            tm.put(sb, l);
        }

        int ctr=0;
        for(Map.Entry<Integer,List<Integer>> e: tm.entrySet()) {
            Collections.sort(e.getValue());
            for(int i : e.getValue()) {
                result[ctr++] = i;
            }
        }

        return result;
    }

    int countSetBits(int i) {
        int ctr = 0;
        while(i != 0) {
            ctr += i & 1;
            i = i >> 1;
        }
        return ctr;
    }
}
