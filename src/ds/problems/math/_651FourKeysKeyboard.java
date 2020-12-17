package ds.problems.math;
//https://www.lintcode.com/problem/4-keys-keyboard/description
//https://www.geeksforgeeks.org/how-to-print-maximum-number-of-a-using-given-four-keys/
//https://leetcode.com/problems/4-keys-keyboard/
//https://www.youtube.com/watch?v=nyR8K63F2KY
public class _651FourKeysKeyboard {

    public int maxA(int N) {
        // write your code here
        int[] solutions = new int[N];
        for(int i=0;i<N;i++) {
            solutions[i] = -1;
        }
        return findTheMax(N,solutions);
    }
    public int findTheMax(int N,int[] solutions) {
        if(N<0) return -1;
        if(N<6) return N;
        int maxSoFar = 0,multiplier = 2;
        for(int i=N-3;i>=0;i--) {
            if(solutions[i] == -1) {
                solutions[i] = findTheMax(i,solutions);
            }
            int current = multiplier * solutions[i];
            if(current>maxSoFar) {
                maxSoFar = current;
            }
            multiplier+=1;
        }
        return maxSoFar;
    }
}
