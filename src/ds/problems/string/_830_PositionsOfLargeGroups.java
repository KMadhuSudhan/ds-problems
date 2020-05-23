package ds.problems.string;
//https://leetcode.com/problems/positions-of-large-groups/
//830. Positions of Large Groups

import java.util.ArrayList;
import java.util.List;

public class _830_PositionsOfLargeGroups {
    public static void main(String[] args) {
        _830_PositionsOfLargeGroups positionsOfLargeGroups = new _830_PositionsOfLargeGroups();
        System.out.println(positionsOfLargeGroups.largeGroupPositions("abbxxxxzyy"));
    }
    public List<List<Integer>> largeGroupPositions(String S) {
        char[] chars = S.toCharArray();
        List<List<Integer>> ans = new ArrayList();
        int i=0,length = chars.length;
        while(i<length)  {
            char currentChar = chars[i];
            int size = 0,j=i;
            while(i < length && currentChar == chars[i]){
                i++;
                size++;
            }
            if(size>=3) {
                List<Integer> list = new ArrayList();
                list.add(j);
                list.add(i-1);
                ans.add(list);
            }
        }
        return ans;
    }
}
