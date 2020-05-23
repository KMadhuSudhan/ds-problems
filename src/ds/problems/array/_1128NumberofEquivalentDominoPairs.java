package ds.problems.array;
//https://leetcode.com/problems/number-of-equivalent-domino-pairs/
//1128. Number of Equivalent Domino Pairs

import java.util.HashMap;
import java.util.Map;

public class _1128NumberofEquivalentDominoPairs {
    public static void main(String[] args) {
        int[][] pairs = {
                {1,2},
                {1,2},
                {1,1},
                {1,2},
                {2,2}
        };

        _1128NumberofEquivalentDominoPairs numberofEquivalentDominoPairs = new _1128NumberofEquivalentDominoPairs();
        System.out.println(numberofEquivalentDominoPairs.numEquivDominoPairs(pairs));
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer,Integer> hsmap=new HashMap<>();
        for(int i=0;i<dominoes.length;i++)
        {
            int a=Math.min(dominoes[i][0],dominoes[i][1]);
            int b=Math.max(dominoes[i][0],dominoes[i][1]);
            int key1=a*10+ b;
            hsmap.put(key1,hsmap.getOrDefault(key1,0)+1);
        }
        int count=0;
        for(Integer i:hsmap.values())
        {
            count+=(i*(i-1))/2;
        }
        return count;
    }

    /*public int numEquivDominoPairs(int[][] dominoes) {
        Map<Integer, Integer> map = new HashMap<>();
        int result =0;
        for( int[] row : dominoes) {
            int a = Math.min( row[0], row[1]);
            int b = Math.max( row[0], row[1]);
            Integer key = getKey(a, b);
            result += map.getOrDefault(key, 0);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return result;
    }

    private int getKey( int a, int b ) {
        return a*10 + b;
    }*/
}
