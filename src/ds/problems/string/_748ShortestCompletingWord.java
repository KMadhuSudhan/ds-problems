package ds.problems.string;
//748. Shortest Completing Word
//https://leetcode.com/problems/shortest-completing-word/
public class _748ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        char[] chars = licensePlate.toCharArray();
        int[] cnt = new int[26];
        char[] wordChars;
        String ans = "1234567891234567";
        int index = 0;
        for(int i=0;i<chars.length;i++) {
            char ch = chars[i];
            if(ch>='0' && ch<= '9' || ch == ' ') continue;
            if(isUpperCase(ch)) {
                ch = (char) (ch  + 32);
            }
            chars[index++] = ch;
        }

        for(int i=words.length-1;i>=0;i--) {
            wordChars = words[i].toCharArray();
            cnt = new int[26];
            for(char c: wordChars) {
                cnt[c - 'a']++;
            }
            boolean found = true;
            for(int j=0;j<index;j++) {
                char ch = chars[j];
                if(cnt[ch - 'a'] == 0) {
                    found = false;
                    break;
                }
                cnt[ch - 'a']--;
            }
            if(found) {
                if(words[i].length() <= ans.length()) {
                    ans = words[i];
                }
            }
        }
        return ans;
    }

    boolean isUpperCase(char ch) {
        return ch>=65 && ch<=90;
    }
}
