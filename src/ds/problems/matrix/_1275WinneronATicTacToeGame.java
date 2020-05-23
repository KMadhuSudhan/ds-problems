package ds.problems.matrix;
//https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/submissions/
//1275. Find Winner on a Tic Tac Toe Game

public class _1275WinneronATicTacToeGame {
    public static void main(String[] args) {
        _1275WinneronATicTacToeGame winnerOnTicTacToe = new _1275WinneronATicTacToeGame();
        int[][] moves = {
                {0, 0},
                {1, 1},
                {2, 0},
                {1, 0},
                {1, 2},
                {2, 1},
                {0, 1},
                {0, 2},
                {2, 2}
        };
        winnerOnTicTacToe.tictactoe(moves);
    }

    public String tictactoe(int[][] moves) {
        Tictactoe tictactoe = new Tictactoe(3);
        String res = "";
        for (int i=0;i<moves.length;i++) {
            String player = i%2 == 0 ? "A" : "B";
            res = tictactoe.move(moves[i][0],moves[i][1],player);
        }
        if (res == null && moves.length == 9) {
            return "Draw";
        } else if (res == null) {
            return "Pending";
        } else {
            return res;
        }
    }

    class Tictactoe {
        int[] rows;
        int[] cols;
        int diagonal;
        int antiDiagonal;

        Tictactoe(int length) {
            rows = new int[length];
            cols = new int[length];
        }

        String move(int row, int col, String player) {
            int add = player == "A" ? 1 : -1;
            rows[row] += add;
            cols[col] += add;
            if (row == col) {
                diagonal += add;
            }
            if (cols.length - row - 1 == col) {
                antiDiagonal += add;
            }
            int size = rows.length;

            if (Math.abs(rows[row]) == size
                    || Math.abs(cols[col]) == size
                    || Math.abs(diagonal) == size
                    || Math.abs(antiDiagonal) == size) {
                return player;
            }
            return null;
        }
    }
}
