package ds.problems.matrix;
//https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/
//1253. Reconstruct a 2-Row Binary Matrix

import java.util.ArrayList;
import java.util.List;

public class _1253ReconstructABinaryMatrix {

    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        if (upper < 0 || lower < 0 || null == colsum || colsum.length == 0)
            return result;
        int sum = 0;
        for (int i : colsum) {
            sum += i;
        }
        if (upper + lower != sum)
            return result;
        result.add(0, new ArrayList<>());
        result.add(1, new ArrayList<>());
        for (int c = 0; c < colsum.length; c++) {
            if (colsum[c] == 2) {
                result.get(0).add(1);
                result.get(1).add(1);
                upper--;
                lower--;
            } else if(colsum[c] == 1){
                if(upper > lower) {
                    result.get(0).add(1);
                    result.get(1).add(0);
                    upper--;
                } else {
                    result.get(0).add(0);
                    result.get(1).add(1);
                    lower--;
                }
            }else {
                result.get(0).add(0);
                result.get(1).add(0);
            }
        }
        if(upper < 0 || lower < 0)
            return new ArrayList<>();
        return result;
    }
}
