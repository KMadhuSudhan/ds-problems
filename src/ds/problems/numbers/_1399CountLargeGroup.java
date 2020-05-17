package ds.problems.numbers;
//https://leetcode.com/problems/count-largest-group/
//1399. Count Largest Group

import java.util.HashMap;
import java.util.Map;

public class _1399CountLargeGroup {
    public static void main(String[] args) {
        _1399CountLargeGroup countLargeGroup = new _1399CountLargeGroup();
        countLargeGroup.countLargestGroup(13);
    }
    public int countLargestGroup(int n) {
        if(n == 0) return 1;
        Map<Integer,Integer> map = new HashMap();
        int max = 1;
        for(int i=1;i<=n;i++) {
            if(n<=9) {
                map.put(i,1);
            } else {
                int sum = sum(i);
                int frq = map.getOrDefault(sum,0);
                frq++;
                max  = Math.max(max,frq);
                map.put(sum,frq);
            }
        }
        int count = 0;
        for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() == max) count++;
        }
        return count;
    }

    int sum(int n){
        int sum = 0;
        while(n!=0) {
            sum+=n%10;
            n/=10;
        }
        return sum;
    }
}
