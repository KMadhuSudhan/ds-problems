package ds.problems.math;
//https://leetcode.com/problems/water-and-jug-problem/
//365. Water and Jug Problem

public class _365WaterAndJugProblem {

    public static void main(String[] args) {
        _365WaterAndJugProblem waterAndJugProblem = new _365WaterAndJugProblem();
        System.out.println(waterAndJugProblem.canMeasureWater(1,2,3));
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if(z > x + y) return false;
        int gcd = gcd(x,y);
        return x==z || y == z || x+y == z || z%gcd == 0;
    }

    int gcd(int a,int b) {
        if(b == 0 ) {
            return a;
        }
        return gcd(b,a%b);
    }
}
