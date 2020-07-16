package ds.problems.matrix;
//https://leetcode.com/problems/count-submatrices-with-all-ones/
//1504. Count Submatrices With All Ones

import java.util.Stack;

public class _1504CountSubmatricesWithAllOne {
    public static void main(String[] args) {
        _1504CountSubmatricesWithAllOne countSubmatricesWithAllOne = new _1504CountSubmatricesWithAllOne();
        int[][] mat = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        countSubmatricesWithAllOne.numSubmat(mat);
    }
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        if(rows == 0 ) return 0;
        int cols = mat[0].length;
        int count =0;
        int[] h = new int[cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                h[j] = mat[i][j] == 0 ? 0 : h[j] + 1;
            }
            count+= helper(h);
        }
        return count;
    }
    int helper(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int[] sum = new int[A.length];
        for(int i=0;i<A.length;i++) {
            while (!stack.isEmpty() && A[stack.peek()] > A[i]) {
                stack.pop();
            }
            if(!stack.isEmpty()) {
                int preIndex = stack.peek();
                sum[i] = sum[preIndex];
                sum[i] += A[i]*(i-preIndex);
            } else {
                sum[i] = A[i] * (i + 1);
            }
            stack.push(i);
        }
        int res = 0;
        for (int s : sum) res += s;

        return res;
    }
}
