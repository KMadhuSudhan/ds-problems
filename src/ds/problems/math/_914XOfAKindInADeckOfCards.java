package ds.problems.math;
//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
//914. X of a Kind in a Deck of Cards


import java.util.HashMap;
import java.util.Map;

public class _914XOfAKindInADeckOfCards {

    public boolean hasGroupsSizeX(int[] deck) {
        if(deck.length == 1) return false;
        Map<Integer,Integer> map = new HashMap();
        int maxFreq = 0;
        for(int i=0;i<deck.length;i++) {
            int count = map.getOrDefault(deck[i],0);
            count++;
            maxFreq = Math.max(maxFreq,count);
            map.put(deck[i],count);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() !=maxFreq) return  false;
        }
        return true;
    }

}
