package ds.problems.string;

//https://leetcode.com/problems/print-words-vertically/
//1324. Print Words Vertically

import java.util.ArrayList;
import java.util.List;

public class _1324PrintWordsVertically {
    public static void main(String[] args) {
        _1324PrintWordsVertically printWordsVertically = new _1324PrintWordsVertically();
       System.out.print(printWordsVertically.printVertically("TO BE OR NOT TO BE"));
    }
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;
        for(int i=0;i<words.length;i++) {
            int len = words[i].length();
            maxLen = Math.max(maxLen,len);
        }
        Character[][] matrix = new Character[words.length][maxLen];
        for(int i=0;i<words.length;i++) {
            for (int j=0;j<maxLen;j++) {
                if(words[i].length() <= j){
                    matrix[i][j] = ' ';
                    continue;
                }
                matrix[i][j] = words[i].charAt(j);
            }
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<maxLen;i++) {
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<words.length;j++) {
                    sb.append(matrix[j][i]);
            }
            char[] chars = sb.toString().toCharArray();
            int lastIndex = 0;
            for(int k=0;k<chars.length;k++) {
                if(chars[k]!= ' ') {
                    lastIndex = k;
                }
            }
            ans.add(sb.substring(0,lastIndex+1));
        }
        return ans;
    }
}
