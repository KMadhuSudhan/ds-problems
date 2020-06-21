package ds.problems.array;
//https://leetcode.com/problems/best-sightseeing-pair/
//1014. Best Sightseeing Pair

public class _1014BestSightseeingPair {

    public int maxScoreSightseeingPair(int[] A) {
        int start=0;
        int max=0;
        for(int i=1;i<A.length;i++){
            int score=A[start]+A[i]+start-i;
            max=Math.max(max,score);
            if(A[i]-A[start]>=start-i){
                start=i;
            }
        }
        return max;
    }
}
