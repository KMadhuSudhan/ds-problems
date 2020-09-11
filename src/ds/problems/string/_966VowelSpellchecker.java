package ds.problems.string;
//https://leetcode.com/problems/vowel-spellchecker/submissions/
//966. Vowel Spellchecker
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _966VowelSpellchecker {
    Set<String> wordPerfect; // store wordList
    Map<String, String> wordCap; // map from lowercase to original
    Map<String, String> wordVowel; // map from lowercase(without voewl) to original

    public String[] spellchecker(String[] wordlist, String[] queries) {
        wordPerfect = new HashSet<>();
        wordCap = new HashMap<>();
        wordVowel = new HashMap<>();
        for (String word : wordlist) {
            wordPerfect.add(word);

            String wordLowCase = word.toLowerCase();
            wordCap.putIfAbsent(wordLowCase, word);

            String wordLowDevowel = devowel(wordLowCase);
            wordVowel.putIfAbsent(wordLowDevowel, word);
        }
        String[] ans = new String[queries.length];
        int i = 0;
        for (String query : queries) {
            ans[i++] = solve(query);
        }
        return ans;
    }

    private String solve(String query) {
        if (wordPerfect.contains(query)) {
            return query;
        }
        String keyLowCase = query.toLowerCase();
        if (wordCap.containsKey(keyLowCase)) {
            return wordCap.get(keyLowCase);
        }
        String deVowel = devowel(keyLowCase);
        if (wordVowel.containsKey(deVowel)) {
            return wordVowel.get(deVowel);
        }
        return "";
    }

    private String devowel(String word) {
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            sb.append(isVowel(c) ? '*' : c);
        }
        return sb.toString();
    }

    private boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
            return true;
        }
        return false;

    }
}
