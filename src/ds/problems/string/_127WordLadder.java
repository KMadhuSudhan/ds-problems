package ds.problems.string;
//https://leetcode.com/problems/word-ladder/
//127. Word Ladder

import java.util.*;

public class _127WordLadder {


    public int ladderLength(String start, String target, List<String> wordList) {
        Set<String> D = new HashSet(wordList);
        if (!D.contains(target))
            return 0;

        // To store the current chain length
        // and the length of the words
        int level = 0, wordlength = start.length();

        // Push the starting word into the queue
        Queue<String> Q = new LinkedList<>();
        Q.add(start);

        // While the queue is non-empty
        while (!Q.isEmpty()) {

            // Increment the chain length
            ++level;

            // Current size of the queue
            int sizeofQ = Q.size();

            // Since the queue is being updated while
            // it is being traversed so only the
            // elements which were already present
            // in the queue before the start of this
            // loop will be traversed for now
            for (int i = 0; i < sizeofQ; ++i) {

                // Remove the first word from the queue
                char[] word = Q.peek().toCharArray();
                Q.remove();

                // For every character of the word
                for (int pos = 0; pos < wordlength; ++pos) {

                    // Retain the original character
                    // at the current position
                    char orig_char = word[pos];

                    // Replace the current character with
                    // every possible lowercase alphabet
                    for (char c = 'a'; c <= 'z'; ++c) {
                        word[pos] = c;

                        // If the new word is equal
                        // to the target word
                        if (String.valueOf(word).equals(target))
                            return level + 1;

                        // Remove the word from the set
                        // if it is found in it
                        if (!D.contains(String.valueOf(word)))
                            continue;
                        D.remove(String.valueOf(word));

                        // And push the newly generated word
                        // which will be a part of the chain
                        Q.add(String.valueOf(word));
                    }

                    // Restore the original character
                    // at the current position
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }
}
