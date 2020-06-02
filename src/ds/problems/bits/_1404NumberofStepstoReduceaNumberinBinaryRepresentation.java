package ds.problems.bits;
//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/
//1404. Number of Steps to Reduce a Number in Binary Representation to One

public class _1404NumberofStepstoReduceaNumberinBinaryRepresentation {

    public static void main(String[] args) {
        _1404NumberofStepstoReduceaNumberinBinaryRepresentation numberofStepstoReduceaNumberinBinaryRepresentation = new _1404NumberofStepstoReduceaNumberinBinaryRepresentation();
        numberofStepstoReduceaNumberinBinaryRepresentation.numSteps("1101");
    }
    public int numSteps(String s) {
        int step = 0;
        int carry = 0;
        int i = s.length()-1;

        while (i >= 0) {
            if (i == 0 && carry == 0) {
                break;
            }
            int digit = s.charAt(i)-'0' + carry;
            if (digit == 0) {
                step += 1;
            } else if (digit == 1) {
                step += 2;
                carry = 1;
            } else {
                step += 1;
                carry = 1;
            }
            i --;
        }
        return step;
    }
}
