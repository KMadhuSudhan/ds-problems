package ds.problems.string;
//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
//1047. Remove All Adjacent Duplicates In String

public class _1047RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        int k =2;
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean removedChars = true;
        int i=0;
        while(removedChars) {
            removedChars = false;
            sb = new StringBuilder();
            while(i < chars.length) {
                int size = 0;
                char currentChar = chars[i];
                while(i <chars.length && chars[i] == currentChar && size <k) {
                    i++;
                    size++;
                }
                if(size>=k) {
                    removedChars = true;
                } else {
                    sb.append(chars[i-size]);
                    i = i - size;
                    i++;
                }
            }
            chars = sb.toString().toCharArray();
            i=0;
        }
        return sb.toString();
    }
}
