package ds.problems.matrix;
//https://leetcode.com/problems/diagonal-traverse-ii/
//1424. Diagonal Traverse II

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1424DiagonalTraverseII {
    public static void main(String[] args) {
        List<List<Integer>> matrix = new ArrayList<>();
        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(3);
        matrix.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(4);
        row2.add(5);
        row2.add(6);
        matrix.add(row2);


        List<Integer> row3 = new ArrayList<>();
        row3.add(7);
        row3.add(8);
        row3.add(9);
        matrix.add(row3);
        _1424DiagonalTraverseII diagonalTraverseII = new _1424DiagonalTraverseII();
        int[] ans = diagonalTraverseII.findDiagonalOrder(matrix);

        for (int num : ans) {
            System.out.print(" " + num);
        }
    }

//    public int[] findDiagonalOrder(List<List<Integer>> nums) {
//        List<Integer> list = new ArrayList();
//        int row = 0;
//        while (row < nums.size()) {
//            int c = 0;
//            int r = row;
//            while (r >= 0 && nums.get(r).size() > 0) {
//                list.add(nums.get(r).get(c));
//                r--;
//                c++;
//            }
//            row++;
//        }
//
//        int col = 1;
//        while (col < nums.get(0).size()) {
//            int r = nums.size()-1;
//            int c = col;
//            while(c<nums.get(r).size()) {
//                list.add(nums.get(r).get(c));
//                r--;
//                c++;
//            }
//            col++;
//        }
//
//        int[] ans = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            ans[i] = list.get(i);
//        }
//        return ans;
//    }


    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,List<Integer>> listHashMap = new HashMap<>();
        int count = 0,maxKey = 0;
        for (int i = nums.size() - 1;i>=0;i--) {
            for (int j = 0;j< nums.get(i).size();j++) {
                int key = i+j;
                List<Integer> list = listHashMap.getOrDefault(key,new ArrayList<>());
                list.add(nums.get(i).get(j));
                listHashMap.put(key,list);
                maxKey = Math.max(maxKey,key);
                count++;
            }
        }

        int[] result = new int[count];
        count = 0;
        for (int key=0;key<=maxKey;key++) {
            List<Integer> list = listHashMap.get(key);
            for (int i: list) result[count++] = i;
        }
        return result;
    }
}
