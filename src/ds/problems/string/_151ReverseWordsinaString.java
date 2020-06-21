package ds.problems.string;
//https://leetcode.com/problems/reverse-words-in-a-string/
//151. Reverse Words in a String

import java.util.ArrayList;
import java.util.List;

public class _151ReverseWordsinaString {

    public String reverseWords(String s) {
        String input = s.trim();
        String[] words = input.split(" ");
        List<String> newWords = new ArrayList();

        for(int i=0;i<words.length;i++) {
            if(words[i].length() == 0) continue;
            newWords.add(words[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=newWords.size()-1;i>0;i--) {
            sb.append(newWords.get(i));
            sb.append(" ");
        }
        if(newWords.size() > 0 && newWords.get(0).length() > 0) sb.append(newWords.get(0));
        return sb.toString();
    }
}
