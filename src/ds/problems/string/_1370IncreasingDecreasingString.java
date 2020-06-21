package ds.problems.string;
//https://leetcode.com/problems/increasing-decreasing-string/
//1370. Increasing Decreasing String

public class _1370IncreasingDecreasingString {

    public String sortString(String s) {
        int[] map = new int[26];
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++) {
            map[chars[i] - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(count < chars.length) {
            for(int i=0;i<26;i++) {
                if(map[i] > 0) {
                    map[i]--;
                    count++;
                    sb.append((char) ('a' + i));
                }
            }

            for(int i=25;i>=0;i--) {
                if(map[i] > 0) {
                    map[i]--;
                    count++;
                    sb.append((char) ('a' + i));
                }
            }
        }
        return sb.toString();
    }
}
