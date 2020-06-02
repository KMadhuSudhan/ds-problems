package ds.problems.string;
//https://leetcode.com/problems/reorganize-string/
//767. Reorganize String

import java.util.Arrays;

public class _767ReorganizeString {

    public String reorganizeString(String S) {
        int[][] arr = new int[26][2];
        char[] chars = S.toCharArray();
        for(int i=0;i<chars.length;i++) {
            arr[chars[i] - 'a'][0] = chars[i];
            arr[chars[i] - 'a'][1]++;
            if(arr[chars[i] - 'a'][1] > (chars.length+1)/2) return "";
        }
        Arrays.sort(arr,(a,b) -> b[1] - a[1]);
        char[] result = new char[chars.length];
        int index = 0;
        for(int i=0;i<26;i++) {
            while (arr[i][1]-- > 0) {
                result[index] = (char)arr[i][0];
                index+=2;
                if(index > chars.length-1) {
                    index = 1;
                }
            }

        }
        return new String(result);
    }
}
