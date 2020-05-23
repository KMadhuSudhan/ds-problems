package ds.problems.matrix;
//https://leetcode.com/problems/maximal-rectangle/
//85. Maximal Rectangle

import java.util.Stack;

public class _85MaximalRectangle {

    public static void main(String[] args) {
        _85MaximalRectangle maximalRectangle = new _85MaximalRectangle();
        char[][] matrix = new char[][] {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        maximalRectangle.maximalRectangle(matrix);
    }
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if(matrix.length == 0) return 0;
        int cols = matrix[0].length;
        int[][] intMatrix = new int[rows][cols];
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                if(matrix[i][j] == '1') {
                    intMatrix[i][j] = 1;
                }
            }
        }

        int maxArea = 0;
        for (int i=0;i<rows;i++) {
            for (int j=0;j<cols;j++) {
                matrix[i][j] += matrix[i - 1][j];
            }
            int area = histogramArea(intMatrix[i]);
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }

    int histogramArea(int[] a) {
        Stack<Integer> stack = new Stack<>();
        int i=0,area=0,maxArea=0;
        while(i<a.length) {
            if(stack.isEmpty() || a[stack.peek()] <= a[i]) {
                stack.push(i++);
            } else {
                int topVal = a[stack.peek()];
                area = topVal * i;
                stack.pop();
                if (!stack.isEmpty()) {
                    area = topVal * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int topVal = a[stack.peek()];
            area = topVal * i;
            stack.pop();
            if (!stack.isEmpty()) {
                area = topVal * (i - stack.peek() - 1);
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
