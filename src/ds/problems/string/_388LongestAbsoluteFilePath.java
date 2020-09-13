package ds.problems.string;

import java.util.Stack;

public class _388LongestAbsoluteFilePath {
    public static void main(String[] args) {
        _388LongestAbsoluteFilePath longestAbsoluteFilePath = new _388LongestAbsoluteFilePath();
        longestAbsoluteFilePath.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext");
    }
    public int lengthLongestPath(String input) {
        int maxLen = 0;
        if(input == null || input.length() == 0) {
            return maxLen;
        }
        Stack<Integer> stack = new Stack();
        stack.push(0); //Dummy length
        String[] inputArr = input.split("\n");
        for(String inputStr: inputArr) {
            int level = inputStr.lastIndexOf("\t")+1;
            while(level+1 < stack.size()) {
                stack.pop();
            }
            int newLen = stack.peek()+inputStr.length()-level+1; //remove \t add /
            stack.push(newLen);
            //If this string is file
            if(inputStr.contains(".")) {
                maxLen = Math.max(maxLen, newLen-1);
            }
        }

        return maxLen;
    }
}
