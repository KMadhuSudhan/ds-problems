package ds.problems.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1200MInimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList();

        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<arr.length;i++) {
            minDiff = Math.min(minDiff,Math.abs(arr[i] - arr[i-1]));
        }
        for(int i=1;i<arr.length;i++) {
            int diff = Math.abs(arr[i] - arr[i-1]);
            if(diff == minDiff) {
                List<Integer> list = new ArrayList();
                list.add(arr[i-1]);
                list.add(arr[i]);
                ans.add(list);
            }
        }
        return ans;
    }
}
