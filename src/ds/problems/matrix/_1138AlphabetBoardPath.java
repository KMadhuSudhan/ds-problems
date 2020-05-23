package ds.problems.matrix;
//https://leetcode.com/problems/alphabet-board-path/
//1138. Alphabet Board Path


public class _1138AlphabetBoardPath {
    int minLength = Integer.MAX_VALUE;
    String ans = "";
    char[][] board = {
            {'a', 'b', 'c', 'd', 'e'},
            {'f', 'g', 'h', 'i', 'j'},
            {'k', 'l', 'm', 'n', 'o'},
            {'p', 'q', 'r', 's', 't'},
            {'u', 'v', 'w', 'x', 'y'},
            {'z', ' ', ' ', ' ', ' '}
    };

    public static void main(String[] args) {
        _1138AlphabetBoardPath alphabetBoardPath = new _1138AlphabetBoardPath();
        System.out.println(alphabetBoardPath.alphabetBoardPath("leet"));
    }

    public String alphabetBoardPath(String target) {
        char[] chars = target.toCharArray();
        boolean[][] visited = new boolean[6][5];
        dfs(0, 0, chars, 0, ' ', visited, new StringBuilder());
        return ans;
    }

    void dfs(int row, int col, char[] target, int index, char direction, boolean[][] visited, StringBuilder currentPath) {
        if (index == target.length) {
            if (currentPath.length() < minLength) {
                minLength = currentPath.length();
                ans = currentPath.toString();
            }
            return;
        }
        if (row < 0 || col < 0 || row >= 6 || col >= 5 || visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        if (board[row][col] == target[index]) {
            currentPath.append('!');
            index++;
        } else {
            currentPath.append(direction);
        }
        dfs(row + 1, col, target, index, 'U', visited, currentPath);
        dfs(row - 1, col, target, index, 'D', visited, currentPath);
        dfs(row, col + 1, target, index, 'R', visited, currentPath);
        dfs(row, col + 1, target, index, 'L', visited, currentPath);
        currentPath.delete(currentPath.length()-1,currentPath.length());
    }
}
