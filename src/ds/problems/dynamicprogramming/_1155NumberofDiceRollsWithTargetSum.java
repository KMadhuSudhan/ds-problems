package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
//1155. Number of Dice Rolls With Target Sum

import java.util.HashMap;
import java.util.Map;

public class _1155NumberofDiceRollsWithTargetSum {

    Map<String, Integer> map;
    public int numRollsToTarget(int d, int f, int target) {
        map = new HashMap<>();
        return countRollsOut(d,f,target);
    }

    int countRollsOut(int d,int f,int target) {
        String key = d + ":" + target;
        Integer existing = map.get(key);
        if(existing!=null) {
            return existing;
        }
        if(d == 0) {
            return target == 0 ? 1 : 0;
        }
        if(d*f < target || target < d) {
            return 0;
        }
        int result = 0;
        for(int i=1;i<=f;i++) {
            result = result + countRollsOut(d-1,f,target-i);
            result = result % 1000000007;
        }
        map.put(key,result);
        return map.get(key);
    }

}
