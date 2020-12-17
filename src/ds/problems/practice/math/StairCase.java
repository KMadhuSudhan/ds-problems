package ds.problems.practice.math;

import java.util.ArrayList;
import java.util.List;

public class StairCase {
    static List<List<List<Integer>>> ans = new ArrayList<>();
    public static void main(String[] args) {
        StairCase stairCase = new StairCase();
        int[] dp = new int[6];
        for(int i=0;i<=6;i++) {
            ans.add(new ArrayList<>());
        }
        List<Integer> firstStepWays = new ArrayList<>();
        firstStepWays.add(1);

        ans.get(1).add(firstStepWays);

        List<Integer> secondStepWays = new ArrayList<>();
        secondStepWays.add(1);
        secondStepWays.add(1);

        ans.get(2).add(secondStepWays);
        List<Integer> secondStepWays1 = new ArrayList<>();
        secondStepWays1.add(2);
        ans.get(2).add(secondStepWays1);

        stairCase.noOfWays(5);

        System.out.print(ans.get(5));
    }
    public List<List<Integer>> noOfWays(int n) {
        if(!ans.get(n).isEmpty()) return ans.get(n);
        List<List<Integer>> nMinusTwo = noOfWays(n-2);
        nMinusTwo.get(nMinusTwo.size()-1).add(2);

        List<List<Integer>> nMinusOne = noOfWays(n-1);
        nMinusTwo.get(nMinusOne.size()-1).add(1);
        return ans.get(n);
    }
}
//5
//4
//3
//3
//1,1,1
//2,1
//1,2
//#1,2,3,4,5
//
//        step1
//
//#1 =>1
//
//        step2
//#1,1 =>2
//#2
//
//
//step3 =>3
////1,1,1,
////1,2
////2,1


