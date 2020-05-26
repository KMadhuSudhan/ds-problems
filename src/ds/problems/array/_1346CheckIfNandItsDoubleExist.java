package ds.problems.array;
//https://leetcode.com/problems/check-if-n-and-its-double-exist
//1346. Check If N and Its Double Exist


import java.util.HashMap;
import java.util.Map;

public class _1346CheckIfNandItsDoubleExist {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++) {
            map.put(arr[i],i);
        }
        for(int i=0;i<arr.length;i++) {
            if(map.containsKey(arr[i]*2) && map.get(arr[i]*2)!=i)  {
                return true;
            }
        }
        return false;
    }
}
