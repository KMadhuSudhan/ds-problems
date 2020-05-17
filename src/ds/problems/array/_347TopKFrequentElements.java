package ds.problems.array;
//https://leetcode.com/problems/top-k-frequent-elements/
//347. Top K Frequent Elements

import java.util.*;

public class _347TopKFrequentElements {
    public static void main(String[] args) {
        _347TopKFrequentElements topKFrequentElements = new _347TopKFrequentElements();
        int[] nums = {4,1,-1,2,-1,2,3};
        System.out.println(topKFrequentElements.topKFrequent(nums,2));
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            int freq = map.getOrDefault(nums[i],0);
            map.put(nums[i],++freq);
        }
        return sortByValue(map,k);
    }

    int[] sortByValue(Map<Integer,Integer> map,int k) {
        List<Map.Entry<Integer,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Integer,Integer>>() {
            @Override
            public int compare(Map.Entry<Integer,Integer> entry1,Map.Entry<Integer,Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });
        int[] ans = new int[k];
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: list) {
            if(count>= k) break;
            ans[count++] = entry.getKey();
        }
        return ans;
    }
}
