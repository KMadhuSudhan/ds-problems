package ds.problems.math;
//https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
//1237. Find Positive Integer Solution for a Given Equation

import java.util.ArrayList;
import java.util.List;

public class _1237FindPositiveIntegerSolution {
     interface CustomFunction {
    // Returns f(x, y) for any given positive integers x and y.
              // Note that f(x, y) is increasing with respect to both x and y.
              // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
              public int f(int x, int y);
  };

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp;

        for(int i=1; i<=z; i++){
            for(int j=1; j<=z; j++){
                temp = new ArrayList<Integer>();

                if(customfunction.f(i, j) == z){
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }

        return list;
    }

}
