package ds.problems.test;

import java.util.HashMap;
import java.util.Map;

public class Steps {
    int ans = 0;
    public static void main(String[] args) {
        Steps solution = new Steps();
        System.out.print(solution.noOfSteps(5));
    }

    int noOfSteps(int n) {
        Map<Integer,Integer> map = new HashMap<>();
        findNoOfSteps(n);
        return findNoOfSteps(n,map);
//        return ans;
//        return findNoOfSteps(n,map);
    }

    int findNoOfSteps(int n,Map<Integer,Integer> map) {
        if(n == 1) return 1;
        if(map.get(n)!=null) return map.get(n);
        if(n%2 == 0) {
            map.put(n, findNoOfSteps(n/2,map) + map.getOrDefault(n,0));
        } else {
            map.put(n,findNoOfSteps(n*3+1,map) + map.getOrDefault(n,0));
        }
        return map.get(n);
    }

    int findNoOfSteps(int n) {
        if(n == 1) return 1;
        ans++;
        if(n%2 == 0) {
            return findNoOfSteps(n/2);
        }
        return findNoOfSteps(n*3+1);
    }
}
