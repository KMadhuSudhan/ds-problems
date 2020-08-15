package ds.problems.math;
//https://leetcode.com/problems/maximum-swap/
//670. Maximum Swap

import java.util.HashMap;
import java.util.Map;

public class _670MaximumSwap {
    public int maximumSwap(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Map<Character,Integer> map = new HashMap();
        for(int i=0;i<chars.length;i++) {
            map.put(chars[i],i);
        }

        for(int i=0;i<chars.length;i++) {
            for(char ch='9';ch>chars[i];ch--) {
                if(map.containsKey(ch) && map.get(ch) > i) {
                    char tmp = chars[i];
                    chars[i] = chars[map.get(ch)];
                    chars[map.get(ch)] = tmp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }
}
