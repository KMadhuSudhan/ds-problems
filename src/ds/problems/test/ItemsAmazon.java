package ds.problems.test;

import java.util.ArrayList;
import java.util.List;

public class ItemsAmazon {

    public static void main(String[] args) {
        String s = "|||||**|*|*|**|||||**|||*|*|*||||*|*|||||*|**||||***||||";
        ItemsAmazon itemsAmazon = new ItemsAmazon();
        List<Integer> startIndices = new ArrayList<>();
        startIndices.add(1);
        startIndices.add(1);
        List<Integer> endIndices = new ArrayList<>();
        endIndices.add(5);
        endIndices.add(6);
        itemsAmazon.numberOfItems(s,startIndices,endIndices);
    }
    List<Integer> numberOfItems(String s,List<Integer> startIndices,List<Integer> endIndices) {
        List<Integer> ans = new ArrayList<>();
        char[] chars = s.toCharArray();
        int[] itemCount = new int[chars.length];
        int i=0,starCount =0;

        while(i<chars.length && chars[i++]!='|');
        if(i == chars.length) return ans;
        while (i<chars.length) {
            if(chars[i] == '*') {
                starCount++;
                itemCount[i] = itemCount[i-1];
            } else {
                itemCount[i] = itemCount[i-1] + starCount;
                starCount = 0;
            }
            i++;
        }
        for(int index = 0;index<startIndices.size();index++) {
            int start = startIndices.get(index) - 1;
            int end = endIndices.get(index) - 1;
            if(start>0) {
                ans.add(itemCount[end] - itemCount[start - 1]);
            } else {
                ans.add(itemCount[end]);
            }
        }
        return ans;
    }
}
