package ds.problems.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1282GroupThePeopleGivenTheGroupSize {
     public static void main(String[] args) {
         int[] groups = {3,3,3,3,3,1,3};
         _1282GroupThePeopleGivenTheGroupSize groupThePeopleGivenTheGroupSize = new _1282GroupThePeopleGivenTheGroupSize();
         groupThePeopleGivenTheGroupSize.groupThePeople(groups);
    }
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer,List<Integer>> map = new HashMap();
        for(int i=0;i<groupSizes.length;i++) {
            int group = groupSizes[i];
            if(map.containsKey(group)) {
                List<Integer> list = map.get(group);
                if(list.size() == group -1) {
                    list.add(i);
                    ans.add(list);
                    map.remove(group);
                } else {
                    list.add(i);
                    map.put(group,list);
                }
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);

                if(group == 1) {
                    ans.add(list);
                } else {
                    map.put(group,list);
                }
            }
        }
        return ans;
    }
}
