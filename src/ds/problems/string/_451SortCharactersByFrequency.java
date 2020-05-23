package ds.problems.string;
//https://leetcode.com/problems/sort-characters-by-frequency/
//451. Sort Characters By Frequency

import java.util.*;

public class _451SortCharactersByFrequency {
    public static void main(String[] args) {
        _451SortCharactersByFrequency sortCharactersByFrequency = new _451SortCharactersByFrequency();
        sortCharactersByFrequency.frequencySort("tree");
    }
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap();
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            int freq = map.getOrDefault(chars[i],0);
            map.put(chars[i],++freq);
        }
        return sortByValue(map);
    }

    String sortByValue(Map<Character,Integer> map) {
        List<Map.Entry<Character,Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list,new Comparator<Map.Entry<Character,Integer>>() {
            @Override
            public int compare(Map.Entry<Character,Integer> o1,Map.Entry<Character,Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry: list) {
            int count = entry.getValue();
            char key = entry.getKey();
            while(count -- > 0) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}
