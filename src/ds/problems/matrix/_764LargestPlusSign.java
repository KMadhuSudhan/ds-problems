package ds.problems.matrix;
//https://leetcode.com/problems/largest-plus-sign/
//764. Largest Plus Sign

import java.util.Arrays;

public class _764LargestPlusSign {

    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] matrix = new int[N][N];
        for (int i=0;i<N;i++) {
            Arrays.fill(matrix[i],1);
        }
        for (int[] cell: mines) {
            matrix[cell[0]][cell[1]] = 0;
        }

        int maxOrder = 0;
        for (int i=0;i<N;i++) {
            for (int j=0;j<N;j++) {
                if(matrix[i][j] == 0) continue;
                int max =1;
                int p=j-1,q=j+1,r=i-1,s=i+1;
                while (p>=0 && q < N && r>=0 && s<N ){
                    if(matrix[i][p] == 1 && matrix[i][q] == 1 && matrix[r][j] == 1 && matrix[s][j] == 1){
                        max++;
                    } else {
                        break;
                    }
                    p--;
                    q++;
                    r--;
                    s++;
                }
                maxOrder = Math.max(maxOrder,max);
            }
        }
        return maxOrder;
    }
}
