package ds.problems.string;
//https://leetcode.com/problems/making-file-names-unique/
//1487. Making File Names Unique

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _1487MakingFileNamesUnique {
    public String[] getFolderNames(String[] names) {
        Map<String,Integer> map = new HashMap();
        String[] ans = new String[names.length];
        for(int i=0;i<names.length;i++) {
            String name = names[i];
            if(!map.containsKey(name)) {
                map.put(name,1);
                ans[i] = name;
            } else {
                int suffix = map.get(name);
                String tempName = name + "(" + suffix + ")";
                while(map.containsKey(tempName)) {
                    suffix++;
                    tempName = name + "(" + suffix + ")";
                }
                map.put(name,suffix);
                map.put(tempName, 1);
                ans[i] = tempName;
            }
        }
        Stack<String> strings = new Stack<>();
        strings.removeAllElements();
        return ans;
    }
}
