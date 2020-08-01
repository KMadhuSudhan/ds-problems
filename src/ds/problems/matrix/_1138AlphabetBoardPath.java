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
        StringBuilder sb = new StringBuilder();
        int[][] map = new int[26][2];
        for(int i=0;i<26;i++) {
            map[i] = new int[]{i/5,i%5};
        }
        int[] prev = new int[]{0, 0};
        for (char c: target.toCharArray()) {
            int x = map[c - 'a'][0] - prev[0];
            int y = map[c - 'a'][1] - prev[1];
            if (prev[0] == 5) {
                while (x < 0) {
                    sb.append('U');
                    x++;
                }
                while (y > 0) {
                    sb.append('R');
                    y--;
                }
            } else if (map[c - 'a'][0] == 5) {
                while (y < 0) {
                    sb.append('L');
                    y++;
                }
                while (x > 0) {
                    sb.append('D');
                    x--;
                }
            } else {
                while (x > 0) {
                    sb.append('D');
                    x--;
                }
                while (x < 0) {
                    sb.append('U');
                    x++;
                }
                while (y > 0) {
                    sb.append('R');
                    y--;
                }
                while (y < 0) {
                    sb.append('L');
                    y++;
                }
            }
            sb.append('!');
            prev = map[c - 'a'];
        }
        return sb.toString();
    }
}
