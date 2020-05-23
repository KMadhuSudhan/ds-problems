package ds.problems.array;
//https://leetcode.com/problems/partition-array-into-three-parts-with-equal-sum/
//1013. Partition Array Into Three Parts With Equal Sum

public class _1013PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for(int i=0;i<A.length;i++) {
            sum+=A[i];
        }
        int currSum = 0,count = 0 ;
        for(int i=0;i<A.length;i++) {
            currSum+=A[i];
            if(currSum == sum/3) {
                count++;
                currSum = 0;
            }
        }
        return count>=3;
    }
}
