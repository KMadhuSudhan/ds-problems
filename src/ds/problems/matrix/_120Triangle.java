package ds.problems.matrix;
//https://leetcode.com/problems/triangle/
//120. Triangle

import java.util.ArrayList;
import java.util.List;

public class _120Triangle {
    public static void main(String[] args) {
        _120Triangle triangle = new _120Triangle();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> firstList = new ArrayList<>();
        firstList.add(-1);
        lists.add(firstList);

        List<Integer> secondList = new ArrayList<>();
        secondList.add(2);
        secondList.add(3);
        lists.add(secondList);

        List<Integer> third = new ArrayList<>();
        third.add(1);
        third.add(-1);
        third.add(-3);
        lists.add(third);
//
//        List<Integer> fourth = new ArrayList<>();
//        fourth.add(4);
//        fourth.add(1);
//        fourth.add(8);
//        fourth.add(3);
//        lists.add(fourth);

        triangle.minimumTotal(lists);
        System.out.println(triangle.minimumTotal(lists));
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int rows = triangle.size();
        int columns = triangle.get(rows-1).size();
        int[][] result = new int[triangle.size()][columns];
        for(int i = 0 ;i< columns;i++) {
            result[rows-1][i] = triangle.get(rows-1).get(i);
        }
        for(int i=rows-2;i>=0;i--) {
            int columnSize = triangle.get(i).size();
            for (int j=0;j<columnSize;j++) {
                result[i][j] = Math.min(result[i+1][j],result[i+1][j+1]) + triangle.get(i).get(j);
            }
        }
        return result[0][0];
    }
}
