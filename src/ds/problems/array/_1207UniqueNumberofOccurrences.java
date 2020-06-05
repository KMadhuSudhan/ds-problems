package ds.problems.array;
//https://leetcode.com/problems/unique-number-of-occurrences/
//1207. Unique Number of Occurrences

import java.util.*;

public class _1207UniqueNumberofOccurrences {
    public static void main(String[] args) {
        _1207UniqueNumberofOccurrences uniqueNumberofOccurrences = new _1207UniqueNumberofOccurrences();
        int[] nums = {1,2,2,1,1,3};
        System.out.println(uniqueNumberofOccurrences.uniqueOccurrences(nums));
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++) {
            int count = map.getOrDefault(arr[i],0);
            count++;
            map.put(arr[i],count);
        }
        Set<Integer> set = new HashSet<>();
        for(int freq : map.values()) {
            if(set.contains(freq)) return false;
            set.add(freq);
        }
        return true;
    }
}
