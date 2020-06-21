package ds.problems.string;
//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
//1160. Find Words That Can Be Formed by Characters

public class _1160FindWordsThatCanBeFormedbyCharacters {

    public int countCharacters(String[] words, String chars) {
        char[] characters = chars.toCharArray();
        int[] map = new int[26];

        for(char character : characters) {
            map[character - 'a']++;
        }
        int ans = 0;
        for(String str: words) {
            char[] wordChars = str.toCharArray();
            int[] copy = map.clone();
            int i=0;
            for(;i<wordChars.length;i++) {
                if(copy[wordChars[i] - 'a'] > 0) {
                    copy[wordChars[i] - 'a']--;
                } else {
                    break;
                }
            }
            if(i == wordChars.length) ans+=i;
        }
        return ans;
    }
}
