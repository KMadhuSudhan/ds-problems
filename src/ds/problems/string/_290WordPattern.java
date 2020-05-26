package ds.problems.string;

import java.util.HashMap;
import java.util.Map;

public class _290WordPattern {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat fish";
        _290WordPattern wordPattern = new _290WordPattern();
        System.out.println(wordPattern.wordPattern(pattern,str));
    }
    public boolean wordPattern(String pattern, String str) {
        char[] patternChars = pattern.toCharArray();
        String[] words = str.split(" ");
        int patternLength = patternChars.length, wordsLength = words.length;
        if (patternLength != wordsLength) return false;

        Map<Character, String> mapping = new HashMap<>();
        Map<String, Character> reverseMapping = new HashMap<>();

        for (int i = 0; i < patternLength; i++) {
            if (mapping.containsKey(patternChars[i])) {
                if (!mapping.get(patternChars[i]).equals(words[i])) return false;
            } else {
                if (reverseMapping.containsKey(words[i])) return false;
                reverseMapping.put(words[i], patternChars[i]);
                mapping.put(patternChars[i], words[i]);
            }
        }
        return true;
    }
}
