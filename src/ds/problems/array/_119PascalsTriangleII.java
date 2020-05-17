package ds.problems.array;
//https://leetcode.com/problems/pascals-triangle-ii/
//119. Pascal's Triangle II

import java.util.ArrayList;
import java.util.List;

public class _119PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList();
        prevRow.add(1);
        for(int i=1;i<=rowIndex;i++) {
            List<Integer> row = new ArrayList();
            for(int j=0;j<=i;j++) {
                if(j == 0 || j == i) {
                    row.add(1);
                    continue;
                }
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            prevRow = row;
        }
        return prevRow;
    }
}
