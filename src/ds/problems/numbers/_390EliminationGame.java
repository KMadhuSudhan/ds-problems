package ds.problems.numbers;
//https://leetcode.com/problems/elimination-game/
//390. Elimination Game

public class _390EliminationGame {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : (n / 2 - lastRemaining(n / 2) + 1) * 2;
    }
}
