package ds.problems.array;
//https://leetcode.com/problems/h-index/
//274. H-Index

import java.util.Arrays;

public class _274Hindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
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
