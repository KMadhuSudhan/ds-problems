package ds.problems.string;
//https://leetcode.com/problems/remove-duplicate-letters/
//316. Remove Duplicate Letters

import java.util.Stack;

public class _316RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastIndex[chars[i] - 'a'] = i;
        }
        boolean[] seen = new boolean[26];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < chars.length; i++) {
            int c = chars[i] - 'a';
            if (seen[c]) continue;
            while (!stack.isEmpty() && stack.peek() > c && i < lastIndex[stack.peek()]) {
                seen[stack.pop()] = false;
            }
            seen[c] = true;
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append((char) ('a' + stack.pop()));
        }
        return sb.reverse().toString();
    }
}
