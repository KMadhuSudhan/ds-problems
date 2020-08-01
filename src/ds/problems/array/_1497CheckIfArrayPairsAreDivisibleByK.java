package ds.problems.array;
//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
//1497. Check If Array Pairs Are Divisible by k

import java.util.HashMap;
import java.util.Map;

public class _1497CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int num: arr) {
            int rem = num%k;
            if(rem<0) {
                rem+=k;
            }
            if(map.containsKey(rem)) {
                int count = map.get(rem);
                if(count == 1) {
                    map.remove(rem);
                } else {
                    map.put(rem,count-1);
                }
            }  else {
                if(rem == 0) {
                    map.put(0,map.getOrDefault(0,0) +1);
                    continue;
                }
                map.put(k-rem,map.getOrDefault(k-rem,0) +1);
            }
        }
        return map.isEmpty();
    }
}
