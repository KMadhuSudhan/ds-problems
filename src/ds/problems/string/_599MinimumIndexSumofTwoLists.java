package ds.problems.string;
//https://leetcode.com/problems/minimum-index-sum-of-two-lists/
//599. Minimum Index Sum of Two Lists

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _599MinimumIndexSumofTwoLists {
    public static void main(String[] args) {
        _599MinimumIndexSumofTwoLists minimumIndexSumofTwoLists = new _599MinimumIndexSumofTwoLists();
        String[] strs1 = {
                "Shogun", "Tapioca Express", "Burger King", "KFC"
        };

        String[] strs2 = {
                "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"
        };
       System.out.println(minimumIndexSumofTwoLists.findRestaurant(strs1,strs2).length);
    }
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String,Integer> map = new HashMap();
        int minIndex = Integer.MAX_VALUE;
        List<String> ans = new ArrayList();
        for(int i=0;i<list1.length;i++) {
            map.put(list1[i],i);
        }

        for(int i=0;i<list2.length;i++) {
            if(map.containsKey(list2[i])) {
                int sum = i+ map.get(list2[i]);
                if(sum == minIndex) {
                    ans.add(list2[i]);
                }
                else if(sum < minIndex) {
                    minIndex = sum;
                    ans = new ArrayList();
                    ans.add(list2[i]);
                }
            }
        }
        int count = 0;
        String[] res = new String[ans.size()];
        for(String str: ans) {
            res[count++]  = str;
        }
        return res;
    }
}
