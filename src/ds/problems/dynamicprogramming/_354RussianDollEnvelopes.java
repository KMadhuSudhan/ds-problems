package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/russian-doll-envelopes/
//354. Russian Doll Envelopes

import java.util.Arrays;

public class _354RussianDollEnvelopes {
    public static void main(String[] args) {
        _354RussianDollEnvelopes russianDollEnvelopes = new _354RussianDollEnvelopes();
        int[][] russianDolls = new int[][] {
                {46,89},
                {50,53},
                {52,68},
                {72,45},
                {77,81}
        };
        //[[46,89],[50,53],[52,68],[72,45],[77,81]]
        System.out.println(russianDollEnvelopes.maxEnvelopes(russianDolls));
        //[[4,5],[4,6],[6,7],[2,3],[1,1]]
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes,(a, b) ->  a[0]*a[1] - b[0]*b[1]);
        int maCount = 0;
        int[] env = new int[envelopes.length];
        for (int i=1;i<envelopes.length;i++) {
            env[i] = 1;
            for (int j=0;j<i;j++) {
                if(envelopes[j][0] < envelopes[i][0] && envelopes[j][1] < envelopes[i][0]) {
                    env[i] = Math.max(env[i],env[j]+1);
                }
            }
            maCount = Math.max(maCount,env[i]);
        }
        return maCount;
    }
}
