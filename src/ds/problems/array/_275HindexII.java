package ds.problems.array;
//https://leetcode.com/problems/h-index-ii/
//275. H-Index II

public class _275HindexII {
    public int hIndex(int[] citations) {
        //Arrays.sort(citations);
        int n=citations.length;
        for(int i=0;i<n;i++)
        {
            if(citations[i]>=n-i)
            {
                return (n-i);
            }
        }
        return 0;
    }
}
