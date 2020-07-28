package ds.problems.backtracking;
//https://leetcode.com/problems/n-queens-ii/
//52. N-Queens II

import java.util.ArrayList;
import java.util.List;

public class _52NQueensII {
    class Position {
        int row;
        int col;
        Position(int row,int col) {
            this.row = row;
            this.col = col;
        }
    }
    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList();
        Position[] positions = new Position[n];
        solve(0,result,n,positions);
        return result.size();
    }

    void solve(int row,List<List<String>> result,int n,Position[] positions) {
        if(row == n) {
            StringBuilder sb = new StringBuilder();
            List<String> oneResult = new ArrayList<>();
            for(Position p : positions) {
                for(int i=0;i<n;i++) {
                    if(p.col == i) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                oneResult.add(sb.toString());
                sb = new StringBuilder();
            }
            result.add(oneResult);
            return;
        }
        for(int col=0;col<n;col++) {
            boolean foundSafe = true;
            for(int queen=0;queen<row;queen++) {
                if(positions[queen].col == col || positions[queen].col + positions[queen].row == col + row || positions[queen].row - positions[queen].col == row - col) {
                    foundSafe = false;
                    break;
                }
            }

            if(foundSafe) {
                positions[row] = new Position(row,col);
                solve(row+1, result,n,positions);
            }
        }
    }
}
