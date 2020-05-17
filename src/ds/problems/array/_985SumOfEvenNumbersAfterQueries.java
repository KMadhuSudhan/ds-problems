package ds.problems.array;
//https://leetcode.com/problems/sum-of-even-numbers-after-queries/
//985. Sum of Even Numbers After Queries

public class _985SumOfEvenNumbersAfterQueries {
    public static void main(String[] args) {
        _985SumOfEvenNumbersAfterQueries sumOfEvenNumbersAfterQueries = new _985SumOfEvenNumbersAfterQueries();
        int[] nums = {1,2,3,4};
        int[][] queries = new int[][] {
                {1,0},
                {-3,1},
                {-4,0},
                {2,3}
        };
        sumOfEvenNumbersAfterQueries.sumEvenAfterQueries(nums,queries);
    }
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int sum = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]%2 == 0) sum+=A[i];
        }
        for(int i=0;i<queries.length;i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if(A[index]%2 == 0) {
                sum-= A[index];
            }
            A[index]+=val;
            if(A[index]%2 == 0) {
                sum+=A[index];
            }
            ans[i] = sum;
        }
        return ans;
    }
}
