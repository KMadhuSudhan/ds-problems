package ds.problems.string;
//https://leetcode.com/problems/group-anagrams/
//49. Group Anagrams

import java.util.*;

public class _49GroupAnagrams {
    public static void main(String[] args) {
        _49GroupAnagrams groupAnagrams = new _49GroupAnagrams();
        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        System.out.println(groupAnagrams.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (int i=0;i<strs.length;i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> indices = map.getOrDefault(sorted,new ArrayList<>());
            indices.add(strs[i]);
            map.put(sorted,indices);
        }
        return new ArrayList<>(map.values());
    }
}
