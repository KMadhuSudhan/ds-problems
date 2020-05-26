package ds.problems.test;

import java.util.List;
import java.util.Stack;

public class PrisonBreak {
    public static void main(String[] args) {
    }
    public static long prison(int n, int m, List<Integer> h, List<Integer> v) {
        // Write your code here
        int[][] matrix = new int[n][m];
        int length = h.size(),i=0;
        while(i<length) {
            int row = h.get(i);
            int col = v.get(i);
            matrix[row][col] = 1;
            i++;
        }
        int result = maxHistogramArea(m, matrix[0]);
        for (i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
            result = Math.max(result, maxHistogramArea(m, matrix[i]));
        }
        return result;
    }

    static int maxHistogramArea(int C, int[] row) {
        int area, maxArea = 0, i = 0;
        Stack<Integer> stack = new Stack<>();
        while (i < C) {
            if (stack.isEmpty() || row[stack.peek()] <= row[i]) {
                stack.push(i++);
            } else {
                int topVal = row[stack.peek()];
                area = topVal * i;
                stack.pop();
                if (!stack.isEmpty()) {
                    area = topVal * (i - stack.peek() - 1);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        while (!stack.isEmpty()) {
            int top_val = row[stack.peek()];
            stack.pop();
            area = top_val * i;
            if (!stack.empty())
                area = top_val * (i - stack.peek() - 1);
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}
