package ds.problems.string;
//https://leetcode.com/problems/baseball-game/
//682. Baseball Game

public class _682BaseballGame {

    public static void main(String[] args) {
        _682BaseballGame baseballGame = new _682BaseballGame();
        String[] input = new String[]{"5", "2", "C", "D", "+"};
        baseballGame.calPoints(input);
    }

    public int calPoints(String[] ops) {
        int sum = 0, top = -1;
        int[] stack = new int[ops.length];
        for (int i = 0; i < ops.length; i++) {
            if (isCharacter(ops[i])) {
                char ch = ops[i].charAt(0);
                switch (ch) {
                    case '+':
                        int val = 0;
                        if (top >= 0) {
                            sum += stack[top];
                            val += stack[top];
                        }
                        if (top > 0) {
                            sum += stack[top - 1];
                            val += stack[top - 1];
                        }
                        stack[top + 1] = val;
                        top++;
                        break;
                    case 'D':
                        if (top >= 0) {
                            sum += stack[top] * 2;
                            stack[top + 1] = stack[top] * 2;
                            top++;
                        }
                        break;
                    case 'C':
                        if (top >= 0) {
                            sum -= stack[top];
                            top--;
                        }
                        break;
                }
            } else {
                int val = Integer.valueOf(ops[i]);
                sum += val;
                stack[++top] = val;
            }
        }
        return sum;
    }

    boolean isCharacter(String input) {
        char ch = input.charAt(0);
        return ch == '+' || ch == 'D' || ch == 'C';
    }
}
