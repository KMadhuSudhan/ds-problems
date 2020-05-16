package ds.problems.dynamicprogramming;
//https://leetcode.com/problems/climbing-stairs/
//70. Climbing Stairs

public class _70ClimbingStairs {
    public static void main(String[] args) {
        _70ClimbingStairs climbingStairs = new _70ClimbingStairs();
        climbingStairs.climbStairs(2);
    }
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int a = 1;
        int b = 2;
        for(int i= 2;i<n;i++) {
            int c = a+b;
            a=b;
            b=c;
        }
        return b;
    }
}
