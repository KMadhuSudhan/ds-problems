package ds.problems.array;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
//1423. Maximum Points You Can Obtain from Cards

public class _1423MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0 ;
        for( int i = 0 ; i< k ; i ++)
        {
            sum+=cardPoints[i];
        }
        int e =cardPoints.length-1;
        int s =k-1;
        int ans =0 ;
        ans =sum;
        while(s >=0)
        {
            sum-=cardPoints[s];
            sum+=cardPoints[e];
            ans =Math.max(sum,ans);
            s--;
            e--;
        }
        return ans;
    }
}
