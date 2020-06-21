package ds.problems.string;
//https://leetcode.com/problems/unique-morse-code-words/
//804. Unique Morse Code Words

import java.util.HashSet;
import java.util.Set;

public class _804UniqueMorseCodeWords {
    public int uniqueMorseRepresentations(String[] words) {
        String[] strings = new String[] {
                ".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."
        };
        Set<String> ans = new HashSet<>();
        for(String word: words) {
            char[] chars = word.toCharArray();
            StringBuilder sb = new StringBuilder();
            for(char character: chars) {
                sb.append(strings[character - 'a']);
            }
            ans.add(sb.toString());
        }
        return ans.size();
    }
}
