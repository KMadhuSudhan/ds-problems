package ds.problems.string;
//https://leetcode.com/problems/uncommon-words-from-two-sentences/
//884. Uncommon Words from Two Sentences

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _884UncommonWordsfromTwoSentences {

    public String[] uncommonFromSentences(String A, String B) {
        Map<String, Integer> map = new HashMap<>();
        for (String x : A.split(" ")) {
            if (!map.containsKey(x)) map.put(x, 1);
            else {
                int oldCount = map.get(x);
                map.put(x, oldCount + 1);
            }
        }

        for (String x : B.split(" ")) {
            if (!map.containsKey(x)) map.put(x, 1);
            else {
                int oldCount = map.get(x);
                map.put(x, oldCount + 1);
            }
        }

        List<String> result = new ArrayList<>();
        for (String key : map.keySet()) if (map.get(key) ==  1) result.add(key);
        return result.toArray(new String[result.size()]);
    }
}
