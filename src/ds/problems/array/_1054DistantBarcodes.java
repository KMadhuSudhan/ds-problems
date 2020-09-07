package ds.problems.array;
//https://leetcode.com/problems/distant-barcodes/
//1054. Distant Barcodes

import java.util.*;

public class _1054DistantBarcodes {
    public static void main(String[] args) {
        _1054DistantBarcodes distantBarcodes = new _1054DistantBarcodes();
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 3};
        distantBarcodes.rearrangeBarcodes(nums);
    }

    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : barcodes) {
            int frq = map.getOrDefault(num, 0);
            map.put(num, frq+1);
        }
        int index = 0;
        MapSorter mapSorter = new MapSorter(map);
        map = mapSorter.sortByVal();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            int count = entry.getValue();
            while (count -- > 0) {
                barcodes[index] = entry.getKey();
                index+=2;
                if(index>=barcodes.length) {
                    index = 1;
                }
            }
        }
        return barcodes;
    }

    class MapSorter {
        Map<Integer, Integer> map;
        MapSorter(Map<Integer, Integer> map) {
            this.map = map;
        }
        public  Map<Integer, Integer> sortByVal() {
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o1.getValue() - o2.getValue();
                }
            });
            Map<Integer, Integer> sortedMap = new LinkedHashMap<>();
            for(Map.Entry<Integer,Integer> entry: list) {
                sortedMap.put(entry.getKey(),entry.getValue());
            }
            return sortedMap;
        }
    }
}
