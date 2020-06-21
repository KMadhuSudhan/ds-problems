package ds.problems.array;
//https://leetcode.com/problems/height-checker/
//1051. Height Checker

public class _1051HeightChecker {

    public int heightChecker(int[] heights) {
        int[] map = new int[101];
        for(int i=0;i<heights.length;i++) {
            map[heights[i]]++;
        }
        int index = 0,ans = 0;
        for(int i=1;i<=100;i++) {
            int count = map[i];
            while(count-- > 0) {
                if(heights[index]!=i) {
                    ans++;
                }
                index++;
            }
        }
        return ans;
    }
}
