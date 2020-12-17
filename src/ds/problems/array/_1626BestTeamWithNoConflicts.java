package ds.problems.array;
//https://leetcode.com/problems/best-team-with-no-conflicts/
//1626. Best Team With No Conflicts

import java.util.Arrays;
import java.util.Comparator;

public class _1626BestTeamWithNoConflicts {
    public static void main(String[] args) {
        int[] scores = new int[]{4,5,6,5};
        int[] ages = new int[]{2,1,2,1};
//        int[] scores = new int[]{1,3,5,10,15};
//        int[] ages = new int[]{1,2,3,4,5};
        _1626BestTeamWithNoConflicts bestTeamWithNoConflicts = new _1626BestTeamWithNoConflicts();
        bestTeamWithNoConflicts.bestTeamScore(scores,ages);
    }
    public int bestTeamScore(int[] scores, int[] ages) {
        int[][] scoresByAge = new int[scores.length][2];
        for(int i=0;i<scores.length;i++) {
            scoresByAge[i] = new int[]{ages[i],scores[i]};
        }

        Arrays.sort(scoresByAge,(a, b)-> {
            if(a[0] == b[0]) {
                return a[1] - b[1];
            }
            return  a[0] - b[0];
        });
        int arr[]=new int[scores.length];
        for(int i=0;i<scores.length;i++)
        {
            scores[i]=scoresByAge[i][1];
            arr[i]=scores[i];
        }

        for(int i=1;i<scores.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(scores[i]>=scores[j] && arr[i]<arr[j]+scores[i])
                    arr[i]=arr[j]+scores[i];
            }
        }
        int max=0;
        for(int i=0;i<scores.length;i++)
        {
            max=Math.max(arr[i],max);
        }
        return max;
    }
}
