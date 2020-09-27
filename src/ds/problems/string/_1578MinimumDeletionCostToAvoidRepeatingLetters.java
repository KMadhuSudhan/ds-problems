package ds.problems.string;
//https://leetcode.com/problems/minimum-deletion-cost-to-avoid-repeating-letters/
//1578. Minimum Deletion Cost to Avoid Repeating Letters

public class _1578MinimumDeletionCostToAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int ans = 0;
        int n =s.length();
        int i=0 ;
        while(i<n)
        {
            char ch = s.charAt(i) ;
            int mi = cost[i] ;
            int curr =cost[i];
            i++;

            while(i<n && ch==s.charAt(i))
            {
                curr+=cost[i];
                mi = Math.max(mi,cost[i]);
                i++;
            }
            ans+=curr-mi;
        }
        return ans ;
    }
}
