package ds.problems.string;
//https://leetcode.com/problems/simplify-path/
//71. Simplify Path

import java.util.Stack;

public class _71SimplifyPath {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Stack<String> stack = new Stack<>();
        for(String word: words) {
            if(word.isEmpty() || word.equals(".")) continue;
            if(word.equals("..")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(word);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
            sb.insert(0,"/");
        }
        return sb.length() != 0 ? sb.toString() : "/";
    }
}
