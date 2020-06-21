package ds.problems.math;
//https://leetcode.com/problems/unique-binary-search-trees/
//96. Unique Binary Search Trees

public class _96UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if(n<=1) return 1;
        long catalanNo = binomialCoeff(2*n,n);

        return (int) (catalanNo/(long)(n+1));
    }


    long binomialCoeff(int n,int k) {
        long result = 1;
        if(k> n - k) {
            k = n-k;
        }
        for(int i=0;i<k;i++) {
            result*=(n-i);
            result/=(i+1);
        }
        return result;
    }
}
