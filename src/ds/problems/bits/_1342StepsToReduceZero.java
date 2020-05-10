package ds.problems.bits;
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
//1342. Number of Steps to Reduce a Number to Zero

public class _1342StepsToReduceZero {
    public static void main(String[] args) {
        _1342StepsToReduceZero stepsToReduceZero = new _1342StepsToReduceZero();
        stepsToReduceZero.numberOfSteps(6);
    }
    public int numberOfSteps (int num) {
        int steps = 0;
        while(num!=0) {
            if(num%2 == 0){
                num/=2;
            } else {
                num-=1;
            }
            steps++;
        }
        return steps;
    }
}
