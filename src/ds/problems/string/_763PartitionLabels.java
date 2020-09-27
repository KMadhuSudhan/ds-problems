package ds.problems.string;
//https://leetcode.com/problems/partition-labels/
//763. Partition Labels

import java.util.ArrayList;
import java.util.List;

public class _763PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList();
        int last = 0, first=0;
        int[] index = new int[26];
        for (int i = 0; i < S.length(); i++) {
            last = Math.max(S.lastIndexOf(S.charAt(i)), last);
            if (i == last) {
                result.add(last - first + 1);
                first = last + 1;
                i = last;
            }
        }
        return result;
    }
}
