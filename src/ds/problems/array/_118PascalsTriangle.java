package ds.problems.array;
//https://leetcode.com/problems/pascals-triangle/
//118. Pascal's Triangle

import java.util.ArrayList;
import java.util.List;

public class _118PascalsTriangle {
    public static void main(String[] args) {
        _118PascalsTriangle pascalsTriangle = new _118PascalsTriangle();
        pascalsTriangle.generate(5);
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList();
        if(numRows == 0) return result;
        List<Integer> prevRow = new ArrayList();
        prevRow.add(1);
        result.add(prevRow);
        for(int i=1;i<numRows;i++) {
            List<Integer> row = new ArrayList();
            for(int j=0;j<=i;j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            prevRow = row;
            result.add(row);
        }
        return result;
    }
}
