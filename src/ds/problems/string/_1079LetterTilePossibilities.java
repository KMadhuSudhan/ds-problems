package ds.problems.string;
//https://leetcode.com/problems/letter-tile-possibilities/
//1079. Letter Tile Possibilities

import java.util.Arrays;

public class _1079LetterTilePossibilities {

    private int ans = 0;
    public int numTilePossibilities(String tiles) {
        char[] arr = tiles.toCharArray();
        Arrays.sort(arr);
        dfs(arr, new boolean[tiles.length()]);
        return ans;
    }

    private void dfs(char[] arr, boolean[] marked) {
        char pre = ' ';
        for (int i = 0; i < arr.length; i++) {
            if (pre == arr[i] || marked[i]) continue;
            pre = arr[i];
            marked[i] = true;
            ans++;
            dfs(arr, marked);
            marked[i] = false;
        }
    }

}
