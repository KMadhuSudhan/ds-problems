package ds.problems.strings;

import java.util.*;

public class _692TopKFrequentWords {
    public static void main(String[] args) {
        _692TopKFrequentWords frequentWords = new _692TopKFrequentWords();
        String[] words = {
                "i", "love", "leetcode", "i", "love", "coding"
        };
        frequentWords.topKFrequent(words,2);
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < words.length; i++) {
            int freq = map.getOrDefault(words[i], 0);
            map.put(words[i], ++freq);
        }
        return sortByValue(map, k);
    }

    List<String> sortByValue(Map<String, Integer> map, int k) {
        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                int diff = entry2.getValue() - entry1.getValue();
                if (diff == 0) {
                    return entry1.getKey().compareTo(entry2.getKey());
                } else {
                    return entry2.getValue() - entry1.getValue();
                }
            }
        });
        List<String> ans = new ArrayList();
        int count = 0;
        for (Map.Entry<String, Integer> entry : list) {
            if (count >= k) break;
            ans.add(entry.getKey());
            count++;
        }
        return ans;
    }
}
